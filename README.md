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
Prints only chords that are built from the root note specified
>run --root [note name]

>run -r [note name]

Example:
>run --root C#

>run -r Eb

## Search By Notes
Prints only chords that contain the notes specified
>run --search [note1 note2 ...]

>run -s [note1 note2 ...]

Example:
>run --search A C E

>run -s B D F#

## Add New Chord
Adds a new user-defined chord to the library
>run --insert [ROOT type STRUCTURE NOTES FRETS]

>run -i [ROOT type STRUCTURE NOTES FRETS]

Example:
>run --insert A  m  1-b3-5  A-C-E  5-7-7-5-5-5

>run -i F  maj  1-3-5  F-A-C  x-x-3-2-1-1