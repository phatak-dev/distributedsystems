package com.madhukaraphatak.mesos.helloworld

import org.apache.mesos.Protos._
import org.apache.mesos.{SchedulerDriver, Scheduler}

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
 * Implementation of simple Scheduler
 */
class ScalaScheduler() extends Scheduler {
  var _tasks: mutable.Queue[String] = mutable.Queue[String]()

  override def error(driver: SchedulerDriver, message: String) {}

  override def executorLost(driver: SchedulerDriver, executorId: ExecutorID, slaveId: SlaveID, status: Int) {}

  override def slaveLost(driver: SchedulerDriver, slaveId: SlaveID) {}

  override def disconnected(driver: SchedulerDriver) {}

  override def frameworkMessage(driver: SchedulerDriver, executorId: ExecutorID, slaveId: SlaveID, data: Array[Byte]) {}

  override def statusUpdate(driver: SchedulerDriver, status: TaskStatus) {
    println(s"received status update $status")
  }

  override def offerRescinded(driver: SchedulerDriver, offerId: OfferID) {}

  /**
   *
   * This callback is called when resources are available to  run tasks
   *
   */
  override def resourceOffers(driver: SchedulerDriver, offers: java.util.List[Offer]) {

    //for every available offer run tasks
    for (offer <- offers.asScala) {
      println(s"offer $offer")
      _tasks.dequeueFirst(value => true) map (cmdString => {
        val cmd = CommandInfo.newBuilder
          .setValue(cmdString)

        //our task will use one cpu
        val cpus = Resource.newBuilder.
          setType(org.apache.mesos.Protos.Value.Type.SCALAR)
          .setName("cpus")
          .setScalar(org.apache.mesos.Protos.Value.Scalar.newBuilder.setValue(1.0))
          .setRole("*")
          .build

        //generate random task id
        val id = "task" + System.currentTimeMillis()

        //create task with given command
        val task = TaskInfo.newBuilder
          .setCommand(cmd)
          .setName(id)
          .setTaskId(TaskID.newBuilder.setValue(id))
          .addResources(cpus)
          .setSlaveId(offer.getSlaveId)
          .build

        driver.launchTasks(offer.getId, List(task).asJava)
      })
    }
  }

  def submitTasks(tasks: String*) = {
    this.synchronized {
      this._tasks.enqueue(tasks: _*)
    }
  }

  override def reregistered(driver: SchedulerDriver, masterInfo: MasterInfo) {}

  override def registered(driver: SchedulerDriver, frameworkId: FrameworkID, masterInfo: MasterInfo) {}

}
