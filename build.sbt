name := "GuitarChordLibrary"
version := "1.0"
scalaVersion := "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.0-alpha1"

scalacOptions ++= Seq("-deprecation", "-feature")