# A lightweight java logging library and android logging library(alpha).

A reliable(asynchronous and synchronous), high-performance(low latency and high throughput), thread safe(consume and produce), flexible(support extension), clear-model(simple architecture), pure java logging library and android logging library.

Runtime version : OpenJDK 1.8, OpenJDK 11, OpenJDK 17, OpenJDK 21, GraalVM for OpenJDK 11 , GraalVM for OpenJDK 17, GraalVM for OpenJDK 21, Android.

## CE Core features(Community Edition):

01. Support RandomAccessFile and MappedByteBuffer to write log files. ✓
02. Support the high-performance open-source library com.lmax.disruptor. ✓
03. Support parameterized log messages. ✓
04. Support json text and plain text log messages. ✓
05. Support NoGC,not create temporary object(objects, String, char arrays, byte arrays). ✓
06. Support multi-threaded produce and consume log messages. ✓
07. Support split the log file based on the number of lines and file size. ✓
08. Support custom log levels. ✓
09. Support different packages and classes to output to specified log files. ✓
10. Support single flush to log files,Support batch flush to log files. ✓
11. Support elegant offline. ✓
12. Support location(Use the current line parameters to cache location information). ✓
13. Support web servers such as Tomcat. ✓
14. Support extension. ✓
15. Support split the log file based on the date(min interval 1 day) or time(min interval 1 second). ✓
16. Support NoGC datetime. ✓
17. Support System Software Events logs and Application Software Events logs. ✓
18. Support Diagnostic Logs and Audit Logs. ✓
19. Support programmable configuration APIs. ✓
20. Support synchronous mode and asynchronous mode. ✓
21. Support the log file append(max 10 times, then truncate) or truncate(immediately). ✓
22. Support switch(Ignore the log event). ✓
23. Support Filter(datetime filter,conditional filters based on log event fields). ✓
24. Support custom thread model,Allocate a large number of thread variables.Avoid multi-threaded concurrent access and lock issues. ✓
25. Support Static io back pressure(Consumption and production patterns based on queues,coarse-grained). ✓

## EE Core features(Enterprise Edition):

01. Support MDC. ✓
02. Support NDC. ✓
03. Support NoGC Map. ✓
04. Support NoGC Stack. ✓
05. Support NoGC ThreadPool. ✓
06. Support NoGC RingBuffer(MPMC) instead of the high-performance open-source library com.lmax.disruptor. ✓
07. Support any configuration files (YAML, XML, JSON) or some things. ✓
08. Support pattern log messages. ✓
09. Support Static io back pressure(Static Rate Limiter,Traffic Shaping,fine-grained). ✓
10. Support Static Rate Limiter(Token Bucket). ✓
11. Support Static Filter(Static Rate Limiter filter,Traffic Policing filter and Traffic Shaping filter). ✓
12. Support any log event format,like json,text,xml or some things. ✓

## wish list:

01. ~~Support exception stack.~~ ✕
02. ~~Support web manage.~~ ✕
03. ~~Support distributed.~~ ✕
04. ~~Support storage backend to store configuration information.~~ ✕
05. ~~Support location(Use the bytecode tools to convert class files).~~ ✕
06. Support raft.✕
07. Support Dynamic Rate Limiter(TCP Vegas).✕
08. Support Dynamic Filter(Dynamic Rate Limiter filter,Traffic Policing filter and Traffic Shaping filter). ✕
09. Support Dynamic io back pressure(Dynamic Rate Limiter,Traffic Shaping,fine-grained). ✕

## Directory structure:

```java
nogc-api(interface)
nogc-core(implements)
nogc-jmh(test and examples)
style(code style)
```

## Execute the main method, specify the JVM parameter, and the GC log will be output to the console:

Use G1GC：

-Xmx32m -Xms32m -XX:+PrintGC -XX:+UseG1GC

Log storage directory path:

Default to current directory\logs\default\[0-15].log

## **Attention:**

**The log library itself does not generate temporary objects. When the GC thread performs the collection of temporary objects, it collects them quickly, minimizing the burden on the GC.**

**Because there is no temporary object creation, even if the GC thread is always running, the GC recycling action will not be triggered because the recycling conditions are not met.**

**GC-F(GarbageCollection-Free),The meaning of no GC is that there is no garbage that can be collected, and it does not mean that the GC thread stops running.**

## License

[The GPL-2.0 license](LICENSE.txt)