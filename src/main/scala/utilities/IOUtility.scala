package utilities

import model.Chord
import java.io._


/** IOUtility class exists to instantiate singleton object */
class IOUtility {}


/** Singleton IOUtility object */
object IOUtility {


  /** Exports a sequence of Chord objects to a csv file */
  def writeToCSV(filename: String, chords: Seq[Chord]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write(Chord.csvHeaders)
    for (i <- 0 until chords.length) {
      bw.write(chords(i).toCSVFormat())
    }
    bw.close()

    println("\nLibrary has be exported to " + filename + "\n")
  }
}
