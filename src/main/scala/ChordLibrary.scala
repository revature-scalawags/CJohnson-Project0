import scala.io.Source

/** Simple Guitar Chord Library
  * 
  */
object ChordLibrary extends App {
    if (args.length != 0) {
      val file = getFile("GuitarChords.csv")
      parseArgs(args, file)
    } else invalidInputNotify()


    /** Parses argument list
      * 
      * @param args argument list
      * @param file CSV file
      */
    def parseArgs(args: Array[String], file: Source): Unit = args(0) match {
      case "-a" => printContents(file)
      case "-help" => printHelp()
      case _ => invalidInputNotify()
    }


    /** Notifies the user about invalid input arguments */
    def invalidInputNotify(): Unit = println("Invalid Input")


    /** Loads in a file
      *
      * @param fileName The name of the file
      * @return the scala.io.Source object created from the fileName
      */
    def getFile(fileName: String): Source = Source.fromFile(fileName)


    /** Prints the entire contents of a CSV file to the command line
      *
      * @param file The CSV file to be printed
      */
    def printContents(file: Source): Unit = {
      for (line <- file.getLines()) {
        val col = line.split(";")
        println(s"${col(0)} \t ${col(1)} \t ${col(2)} ${spacer(col(2))} ${col(3)} ${spacer(col(3))} ${col(4)}")
      }
    }


    /** Prints help */
    def printHelp(): Unit = {
      println("\nUsage: ChordLibrary [--help] <command> [<args>]\n")
      println("This is a list of commands to be used with ChordLibrary:\n")
      println("\t-a\t\tPrint entire library of chords\n")
    }


    /** Used to format the data output
      *
      * @param text String cell data from the CSV file
      * @return A string containing the appropriate number of tab characters
      */
    def spacer(text: String): String = if (text.length < 6) "\t\t" else "\t"
}