
## Prerequisites

* Java - 1.6+
* Sbt 0.13.6
* Mesos

## Setting up mesos

Please refer to this [blogpost](http://blog.madhukaraphatak.com/mesos-single-node-setup-ubuntu/) for setting up the mesos on your machine.

## Build

    sbt clean package
    
## Running 
   ``` 
   java -cp target/scala-2.11/distrubutedsystemfromscratch_2.11-1.0.jar 
   -Djava.library.path=$MESOS_HOME/src/.libs 
   com.madhu.mesos.DistributedShell "/bin/echo hello" 
   ```