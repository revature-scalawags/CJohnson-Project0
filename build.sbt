name := "GuitarChordLibrary"
version := "1.0"
scalaVersion := "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

scalacOptions ++= Seq("-deprecation", "-feature")