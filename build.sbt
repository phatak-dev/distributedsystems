
import sbt._
import sbt.Keys._

name := "DistrubutedSystemFromScratch"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
   "org.apache.mesos" % "mesos" % "0.25.0",
   "log4j" % "log4j" % "1.2.17",
   "org.eclipse.jetty" % "jetty-server" %"8.1.16.v20140903"
)