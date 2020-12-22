package utilities

import dao.{ChordDAO, ChordDAOImpl}
import model.Chord
import utilities.ChordUtility


/** FlagFunctions class exists to instantiate singleton object */
class FlagFunctions {}


/** Singleton FlagFunctions object */
object FlagFunctions {

  val chordDAO: ChordDAO[Chord] = new ChordDAOImpl


  /** Retrieves all Chord objects from database and prints it to standard output */
  def printAll(): Unit = {
    val chordList = chordDAO.getAll
    ChordUtility.printChordList(chordList)
  }


  /** Retrieves all Chord objects that contain the user-specified notes and prints them to standard output */
  def searchChords(args: Array[String]): Unit = {
    val fullList = chordDAO.getAll
    val chordList = ChordUtility.chordSearch(args, fullList)
    ChordUtility.printChordList(chordList)
  }


  /** Creates a Sequence of Chord objects of prints its contents
    * to standard output  
    *
    * @param args argument list
    */
  def printByRoot(args: Array[String]): Unit = {
    if (args.length < 2) println("Enter a Note.\nTry run --help\n")
    else {
      val chordList = chordDAO.getByRoot(args(1))
      ChordUtility.printChordList(chordList)
    }
  }


  /** Prints help */
  def printHelp(): Unit = {
    println("\nUsage: run [--help] <command> [<args>]\n")
    println("This is a list of commands to be used with ChordLibrary:\n")
    println("\t--all\t\t\t\tPrint entire library of chords\n")
    println("\t--root <note name>\t\tPrint list of chords built from root\n")
    println("\t--search [note1 note2 ...]\tPrint list of chords that contain specific notes\n")
  }


  /** Notifies the user about invalid input arguments */
  def invalidInputNotify(): Unit = println("\nInvalid Input.\nTry run --help\n")
}