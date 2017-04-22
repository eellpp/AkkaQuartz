name := "AkkaQuartzDemo"

version := "1.0"

scalaVersion := "2.11.1"


libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1"

libraryDependencies += "com.google.api-client" % "google-api-client" % "1.22.0"
libraryDependencies += "com.google.oauth-client" % "google-oauth-client-jetty" % "1.22.0"
libraryDependencies += "com.google.apis" % "google-api-services-calendar" % "v3-rev243-1.22.0"
libraryDependencies += "joda-time" % "joda-time" % "2.9.9"
libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.16"
libraryDependencies += "com.enragedginger" % "akka-quartz-scheduler_2.11" % "1.6.0-akka-2.4.x"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

