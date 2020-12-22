name := "GuitarChordLibrary"
version := "1.0"
scalaVersion := "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1"

scalacOptions ++= Seq("-deprecation", "-feature")