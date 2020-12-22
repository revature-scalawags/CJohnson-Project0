package main

import dao.{ChordDAO, ChordDAOImpl}
import model.Chord
import utilities.FlagFunctions

/** Simple Guitar Chord Library Application */
object ChordLibrary extends App {

  // Notify user if not arguments have been passed in
  if (args.length != 0) {
    parseArgs(args)
  } else FlagFunctions.invalidInputNotify()

 
  /** Parses argument list
    * 
    * @param args argument list
    * @param file CSV file
    */
  def parseArgs(args: Array[String]): Unit = args(0) match {
    case "-a" | "--all" => FlagFunctions.printAll()
    case "-r" | "--root" => FlagFunctions.printByRoot(args.slice(1, 2).map(_.toLowerCase().capitalize))
    case "-s" | "--search" => FlagFunctions.searchChords(args.slice(1, args.length).map(_.toLowerCase.capitalize))
    case "-h" | "--help" => FlagFunctions.printHelp()
    case _ => FlagFunctions.invalidInputNotify()
  }
}