#!/bin/sh
echo "running Executor"
export LD_LIBRARY_PATH="/home/madhu/Dev/mesos/mesos-0.25.0/build/src/.libs":$LD_LIBRARY_PATH
#update the path to point to jar
java -cp /home/madhu/Dev/mybuild/DistrubutedSystemFromScratch/target/scala-2.11/DistrubutedSystemFromScratch-assembly-1.0.jar   com.madhukaraphatak.mesos.customexecutor.TaskExecutor