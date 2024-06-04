package time;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.HdrHistogram.Histogram;
import org.jdkstack.logging.nogc.api.recorder.Recorder;
import org.jdkstack.logging.nogc.core.Constants;
import org.jdkstack.logging.nogc.core.factory.LogFactory;

/**
 * serviceTime，latencyTime，responseTime.
 *
 * <p>serviceTime+latencyTime=responseTime。
 *
 * <pre>
 *     <a href="https://groups.google.com/g/mechanical-sympathy/c/0gaBXxFm4hE/m/O9QomwHIJAAJ"></a>.
 * </pre>
 *
 * @author admin
 */
public class TimeTest {

  private static final Recorder LOG = LogFactory.getRecorder(TimeTest.class);

  private static final String LATENCY_MSG = new String(new char[1024]);

  public static void main(final String[] args) throws Exception {
    final int threadCount = 1;
    final int eps = 250000;
    final long start1 = System.currentTimeMillis();
    List<Histogram> serviceTimeWarm = new ArrayList<>(1);
    List<Histogram> responseTimeWarm = new ArrayList<>(1);
    List<Histogram> latencyTimeWarm = new ArrayList<>(1);
    final long warmTime = TimeUnit.MINUTES.toMillis(1);
    final int warmCount = eps / threadCount;
    runLatencyTest(warmTime, warmCount, serviceTimeWarm, responseTimeWarm, latencyTimeWarm, threadCount);
    final long end1 = System.currentTimeMillis();
    System.out.printf("%n%s: %d threads, load %d msg/sec", "Warm", threadCount, eps);
    System.out.println(" ,Warm duration: " + (end1 - start1) / 1000.0 + " seconds");

    final long start = System.currentTimeMillis();
    List<Histogram> serviceTime = new ArrayList<>(1);
    List<Histogram> responseTime = new ArrayList<>(1);
    List<Histogram> latencyTime = new ArrayList<>(1);
    final long testTime = TimeUnit.MINUTES.toMillis(1);
    //
    final int count = eps / threadCount;
    runLatencyTest(testTime, count, serviceTime, responseTime, latencyTime, threadCount);
    final long end = System.currentTimeMillis();

    System.out.printf("%n%s: %d threads, load %d msg/sec", "Test", threadCount, eps);
    System.out.println(" ,Test duration: " + (end - start) / 1000.0 + " seconds");
    System.out.println("responseTime：");
    final Histogram resultResponseTm = createResultHistogram(responseTime, start, end);
    resultResponseTm.outputPercentileDistribution(System.out, 1000.0);

    System.out.println("serviceTime：");
    final Histogram resultServiceTm = createResultHistogram(serviceTime, start, end);
    resultServiceTm.outputPercentileDistribution(System.out, 1000.0);
    System.out.println("latencyTime：");
    final Histogram resultLatencyTm = createResultHistogram(latencyTime, start, end);
    resultLatencyTm.outputPercentileDistribution(System.out, 1000.0);
    Thread.sleep(99999);
  }

  private static void writeToFile(final String suffix, final Histogram hist, final int thousandMsgPerSec, final double scale) throws IOException {
    try (PrintStream pout = new PrintStream(new FileOutputStream(thousandMsgPerSec + "k" + suffix))) {
      hist.outputPercentileDistribution(pout, scale);
    }
  }

  private static Histogram createResultHistogram(final List<Histogram> list, final long start, final long end) {
    final Histogram result = new Histogram(TimeUnit.SECONDS.toMillis(1000), 3);
    result.setStartTimeStamp(start);
    result.setEndTimeStamp(end);
    for (final Histogram hist : list) {
      result.add(hist);
    }
    return result;
  }

  public static void runLatencyTest(final long durationMillis, final int samples, final List<Histogram> serviceTmHistograms, final List<Histogram> responseTmHistograms, List<Histogram> latencyTmHistograms, final int threadCount) throws InterruptedException {
    final Histogram latencyTmHist = new Histogram(TimeUnit.SECONDS.toMillis(1000), 3);
    final Histogram serviceTmHist = new Histogram(TimeUnit.SECONDS.toMillis(1000), 3);
    final Histogram responseTmHist = new Histogram(TimeUnit.SECONDS.toMillis(1000), 3);
    serviceTmHistograms.add(serviceTmHist);
    responseTmHistograms.add(responseTmHist);
    latencyTmHistograms.add(latencyTmHist);
    final Thread[] threads = new Thread[threadCount];
    final CountDownLatch latch = new CountDownLatch(threadCount);
    for (int i = 0; i < threadCount; i++) {
      threads[i] = new Thread("timeTest-" + i) {
        @Override
        public void run() {
          latch.countDown();
          try {
            latch.await(); // wait until all threads are ready to go
          } catch (final InterruptedException e) {
            interrupt();
            return;
          }
          final Pacer pacer = new Pacer(samples);
          long currentTimeMillis = System.currentTimeMillis();
          final long endTimeMillis = currentTimeMillis + durationMillis;
          while (currentTimeMillis < endTimeMillis) {
            final long latencyTime = pacer.expectedNextOperationNanoTime();
            pacer.acquire(1);
            final long serviceStartTime = System.currentTimeMillis();
            LOG.log(Constants.INFO, LATENCY_MSG);
            final long serviceEndTime = System.currentTimeMillis();
            serviceTmHist.recordValue(serviceEndTime - serviceStartTime);
            responseTmHist.recordValue(serviceEndTime - latencyTime);
            latencyTmHist.recordValue(serviceStartTime - latencyTime);
            currentTimeMillis = System.currentTimeMillis();
          }
        }
      };
      threads[i].start();
    }
    for (int i = 0; i < threadCount; i++) {
      threads[i].join();
    }
  }
}
