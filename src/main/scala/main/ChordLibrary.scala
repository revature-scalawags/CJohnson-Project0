package main

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
    case "-r" | "--root" => FlagFunctions.printByRoot(args.slice(1, 2).map(_.toLowerCase.capitalize))
    case "-s" | "--search" => FlagFunctions.searchChords(args.slice(1, args.length).map(_.toLowerCase.capitalize))
    case "-i" | "--insert" => FlagFunctions.insertChord(args.slice(1, args.length))
    case "-d" | "--delete" => FlagFunctions.deleteChord(args.slice(1, 2).map(_.toLowerCase))
    case "-e" | "--export" => FlagFunctions.writeToCSV(args.slice(1, 2).map(_.toLowerCase))
    case "-h" | "--help" => FlagFunctions.printHelp()
    case _ => FlagFunctions.invalidInputNotify()
  }
}