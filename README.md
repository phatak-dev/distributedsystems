
## Prerequisites

* Java - 1.6+
* Sbt 0.13.6
* Mesos

## Setting up mesos

Please refer to this [blogpost](http://blog.madhukaraphatak.com/mesos-single-node-setup-ubuntu/) for setting up the mesos on your machine.

## Build

    sbt clean assembly
    
## Running 
   ``` 
   java -cp target/scala-2.11/DistrubutedSystemFromScratch-assembly-1.0.jar 
   -Djava.library.path=$MESOS_HOME/src/.libs 
   com.madhukaraphatak.mesos.helloworld.DistributedShell "/bin/echo hello" 
   ```
   
## Branches
   
Code in the repository is divided into multiple branches for different parts of the discussion. For latest,
refer to master branch.

* Part 1 - branch-p1

* Part 2 - branch-p2