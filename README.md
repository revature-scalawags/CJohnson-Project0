# Chord Library
A simple guitar chord library application

## Prepare MongoDB
Build a new docker image
>docker build -t chordtestdb .

Run the image
>docker run -p 27017:27017 -d --rm --name chordtestdb chordtestdb

## Compile
>sbt compile

## Test
>sbt test

# Requirements
>Java JDK version 11 (https://adoptopenjdk.net/)

>Scala 2.12 (https://www.scala-lang.org/download/)

>SBT 1.4 (https://www.scala-sbt.org/index.html)

# Usage
While running SBT:

## Help
Opens help menu
>run --help

>run -h

## Print all
Prints the entire chord library to the console
>run --all

>run -a

## Find By Root
Prints only chords that are built from the root note specified to the console
>run --root [note name]

>run -r [note name]

Example:
>run --root C#