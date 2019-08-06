# java-performance-monitor
监控Java虚拟机运行时的各种数据，然后将其存入Mongo

### v0.0.1
每60秒获取JVM中的java线程，然后将 `JPS` 和 `Jstat（目前只有-gc）` 命令获取的数据存入Mongo 
