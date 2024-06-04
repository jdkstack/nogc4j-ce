package time;

/**
 * Pacer determines the pace at which measurements are taken. Sample usage:
 *
 * <p>
 *
 * <pre>
 * - each thread has a Pacer instance
 * - at start of test, call pacer.setInitialStartTime(System.nanoTime());
 * - loop:
 *   - store result of pacer.expectedNextOperationNanoTime() as expectedStartTime
 *   - pacer.acquire(1);
 *   - before the measured operation: store System.nanoTime() as actualStartTime
 *   - perform the measured operation
 *   - store System.nanoTime() as doneTime
 *   - serviceTimeHistogram.recordValue(doneTime - actualStartTime);
 *   - responseTimeHistogram.recordValue(doneTime - expectedStartTime);
 * </pre>
 *
 * <p>Borrowed with permission from Gil Tene's Cassandra stress test:
 * https://github.com/LatencyUtils/cassandra-stress2/blob/trunk/tools/stress/src/org/apache/cassandra/stress/StressAction.java#L374
 */
public class Pacer {

  private long initialStartTime;
  private double throughputInUnitsPerNsec;
  private long unitsCompleted;

  private boolean caughtUp = true;
  private long catchUpStartTime;
  private long unitsCompletedAtCatchUpStart;
  private double catchUpThroughputInUnitsPerNsec;
  private double catchUpRateMultiple;

  public Pacer(final double unitsPerSec) {
    this(unitsPerSec, 3.0); // Default to catching up at 3x the set throughput
  }

  public Pacer(final double unitsPerSec, final double catchUpRateMultiple) {
    setThroughout(unitsPerSec);
    setCatchupRateMultiple(catchUpRateMultiple);
    initialStartTime = System.currentTimeMillis();
  }

  public void setInitialStartTime(final long initialStartTime) {
    this.initialStartTime = initialStartTime;
  }

  public void setThroughout(final double unitsPerSec) {
    // 每毫秒产生M条数据。
    throughputInUnitsPerNsec = unitsPerSec / 1000.0;
    catchUpThroughputInUnitsPerNsec = catchUpRateMultiple * throughputInUnitsPerNsec;
  }

  public void setCatchupRateMultiple(final double multiple) {
    //  N。
    catchUpRateMultiple = multiple;
    // 每毫秒产生N*M条数据。
    catchUpThroughputInUnitsPerNsec = catchUpRateMultiple * throughputInUnitsPerNsec;
  }

  /**
   * @return the time for the next operation
   */
  public long expectedNextOperationNanoTime() {
    return initialStartTime + (long) (unitsCompleted / throughputInUnitsPerNsec);
  }

  public long nsecToNextOperation() {

    final long now = System.currentTimeMillis();

    long nextStartTime = expectedNextOperationNanoTime();

    boolean sendNow = true;

    if (nextStartTime > now) {
      // We are on pace. Indicate caught_up and don't send now.}
      caughtUp = true;
      sendNow = false;
    } else {
      // We are behind
      if (caughtUp) {
        // This is the first fall-behind since we were last caught up
        caughtUp = false;
        catchUpStartTime = now;
        unitsCompletedAtCatchUpStart = unitsCompleted;
      }

      // Figure out if it's time to send, per catch up throughput:
      final long unitsCompletedSinceCatchUpStart = unitsCompleted - unitsCompletedAtCatchUpStart;

      nextStartTime = catchUpStartTime + (long) (unitsCompletedSinceCatchUpStart / catchUpThroughputInUnitsPerNsec);

      if (nextStartTime > now) {
        // Not yet time to send, even at catch-up throughout:
        sendNow = false;
      }
    }

    return sendNow ? 0 : (nextStartTime - now);
  }

  /**
   * Will wait for next operation time. After this the expectedNextOperationNanoTime() will move forward.
   *
   * @param unitCount
   */
  public void acquire(final long unitCount) {
    final long nsecToNextOperation = nsecToNextOperation();
    if (nsecToNextOperation > 0) {
      sleepNs(nsecToNextOperation);
    }
    unitsCompleted += unitCount;
  }

  private void sleepNs(final long ns) {
    long now = System.currentTimeMillis();
    final long deadline = now + ns;
    while ((now = System.currentTimeMillis()) < deadline) {
      Thread.yield();
    }
  }
}
