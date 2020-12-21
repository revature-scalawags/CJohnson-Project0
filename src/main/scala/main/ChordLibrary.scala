package main

import dao.{ChordDAO, ChordDAOImpl}
import model.Chord

/** Simple Guitar Chord Library Application
  * 
  */
object ChordLibrary extends App {

  val chordDAO: ChordDAO[Chord] = new ChordDAOImpl

  if (args.length != 0) {
    parseArgs(args)
  } else invalidInputNotify()

  
  /** Parses argument list
    * 
    * @param args argument list
    * @param file CSV file
    */
  def parseArgs(args: Array[String]): Unit = args(0) match {
    case "-a" | "--all" => {
      val test = chordDAO.getAll
      Chord.printHeaders()
      test.foreach(_.printPretty())
      println()
    }
    case "-r" | "--root" => {
      if (args.length < 2) println("Enter a Note")
      else {
        val test = chordDAO.getRoot(args(1))
        Chord.printHeaders()
        test.foreach(_.printPretty)
        println("")
      }
    }
    case "-h" | "--help" => printHelp()
    case _ => invalidInputNotify()
  }


  /** Notifies the user about invalid input arguments */
  def invalidInputNotify(): Unit = println("\nInvalid Input\n")


  /** Prints help */
  def printHelp(): Unit = {
    println("\nUsage: ChordLibrary [--help] <command> [<args>]\n")
    println("This is a list of commands to be used with ChordLibrary:\n")
    println("\t-a\t\tPrint entire library of chords\n")
  }
}