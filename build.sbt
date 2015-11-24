
import sbt._
import sbt.Keys._

name := "DistrubutedSystemFromScratch"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
   "org.apache.mesos" % "mesos" % "0.25.0",
   "log4j" % "log4j" % "1.2.17"
)