package utilities

import com.typesafe.scalalogging.LazyLogging

import dao.{ChordDAO, ChordDAOImpl}
import model.Chord


/** FlagFunctions class exists to instantiate singleton object */
class FlagFunctions {}


/** Singleton FlagFunctions object */
object FlagFunctions extends LazyLogging {

  val chordDAO: ChordDAO[Chord] = new ChordDAOImpl

  
  /** Retrieves all Chord objects from database and prints it to standard output */
  def printAll(): Unit = {
    val chordList = chordDAO.getAll
    ChordUtility.printChordList(chordList)
  }


  /** Creates a Sequence of Chord objects of prints its contents
    * to standard output  
    *
    * @param args argument list
    */
  def printByRoot(args: Array[String]): Unit = {
    if (args.length < 1) {
      println("\nEnter a Note.\nTry run --help\n")
      logger.info("--root: No root specified")
    }
    else {
      val chordList = chordDAO.getByRoot(args(0))
      ChordUtility.printChordList(chordList)
    }
  }


  /** Retrieves all Chord objects that contain the user-specified notes and prints them to standard output */
  def searchChords(args: Array[String]): Unit = {
    val fullList = chordDAO.getAll
    val chordList = ChordUtility.chordSearch(args, fullList)
    ChordUtility.printChordList(chordList)
  }


  /** Takes user arguments, builds a new Chord object and inserts it into the database. */
  def insertChord(args: Array[String]): Unit = {
    if (args.length < 5) {
      println("\nToo few arguments\n")
      logger.info("--insert: Not enough arguments entered")
    }
    else {
      val fullList = chordDAO.getAll
      val idOfLast = Integer.parseInt(fullList(fullList.length - 1)._id)
      val chord = Chord(
        (idOfLast + 1).toString,                  // _id
        args(0).toLowerCase.capitalize,           // ROOT
        args(1).toLowerCase,                      // TYPE
        args(2).toLowerCase,                      // STRUCTURE
        ChordUtility.formatNoteNames(args(3)),    // NOTE_NAMES
        args(4).toLowerCase                       // FRET_POSITIONS
      )

      chordDAO.insert(chord)
      println("\nNew Chord Added:")
      ChordUtility.printChordList(Seq(chord))
      println()
    }
  }


  /** Matches Chord object to entered FRET_POSITIONS string and removes it from the database */
  def deleteChord(args: Array[String]): Unit = {
    if(args.length == 0) {
      println("\nEnter Fret positions to delete chord. Ex: run -d x-3-2-0-1-0\n")
      logger.info("--delete: No arguments supplied")
    }
    else {
      val chordList = chordDAO.getByFrets(args(0))
      if (chordList.length == 0) {
        println("\nThat chord does not exist in the library\n")
        logger.info("Chord does not exist in library")
      } else {
        chordDAO.delete(chordList(0))
        println("\nChord(s) Deleted:")
        ChordUtility.printChordList(chordList)
        println()
      }
    }
  }

  /** Validates user specified file name and saves contents of the database to a .csv file */
  def writeToCSV(args: Array[String]): Unit = {
    if (args.length > 0) {
      val filename = args(0)

      if (!(filename.slice(filename.length - 4, filename.length)).equalsIgnoreCase(".csv")) {
        println("\nfile name must end with \".csv\"\n")
        logger.info("File name must end with .csv")
      } else {
        val chordList = chordDAO.getAll
        IOUtility.writeToCSV(filename, chordList)
      }

    } else println("Enter a file name. Ex: run -w testFile.csv")
    
  }


  /** Prints help */
  def printHelp(): Unit = {
    println("\nUsage: run [--help] <command> [<args>]\n")
    println("This is a list of commands to be used with ChordLibrary:\n")
    println("\t--all\t\t\t\t\t\tPrint entire library of chords\n")
    println("\t--root <note name>\t\t\t\tPrint list of chords built from root\n")
    println("\t--search [note1 note2 ...]\t\t\tPrint list of chords that contain specific notes\n")
    println("\t--insert [ROOT TYPE STRUCTURE NOTES FRETS]\tInsert new chord into the library\n")
    println("\t--delete <FRETS>\t\t\t\tDelete chords with matching fret positions from the library\n")
    println("\t--export <filename.csv>\t\t\t\tExport library to .csv file\n")
  }


  /** Notifies the user about invalid input arguments */
  def invalidInputNotify(): Unit = println("\nInvalid Input.\nTry run --help\n"); logger.info("Invalid input")
}