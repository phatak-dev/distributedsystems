package com.madhukaraphatak.mesos.helloworld

import org.apache.mesos.MesosSchedulerDriver
import org.apache.mesos.Protos.FrameworkInfo

/**
 * Created by madhu on 30/9/14.
 */

/**
 * Client program which will launch shell commands on cluster
 * Read README.md for example invocation.
 */
object DistributedShell {

  def main(args: Array[String]) {

    val framework = FrameworkInfo.newBuilder.
    setName("DistributedShell").
    setUser("").
    setRole("*").
    setCheckpoint(false).
    setFailoverTimeout(0.0d).
    build()

    //create instance of schedule and connect to mesos
    val scheduler = new ScalaScheduler
    //submit shell commands
    scheduler.submitTasks(args:_*)
    val mesosURL = "localhost:5050"
    val driver = new MesosSchedulerDriver(scheduler,framework,mesosURL)
    //run the driver
    driver.run()





  }


}
