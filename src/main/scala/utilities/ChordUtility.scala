package utilities

import model.Chord

/** ChordUtility class exists to instantiate singleton object */
class ChordUtility{}

/** Singleton ChordUtility object */
object ChordUtility {

  /** Returns an array of notes that make up a chord */
  def getNoteArray(chord: Chord): Array[String] = chord.NOTE_NAMES.split("-")


  /** Returns an array of notes from a NOTES_NAME string */
  def getNoteArray(notes: String): Array[String] = notes.split("-")


  /** Returns a Sequence of Chord objects whose notes match the notes contained
    * in the user's argument array.
    * 
    * @param args User specified array of notes to search for
    * @param fullList The full list of chords in the library
    * @return A collection of chords that share all notes with args
    */
  def chordSearch(args: Array[String], fullList: Seq[Chord]): Seq[Chord] = {
    for {
      c <- fullList
      if args.forall(getNoteArray(c).contains)
    } yield c
  }


  /** Prints formatted collection of Chord objects to standard output */
  def printChordList(chordList: Seq[Chord]): Unit = {
    if (chordList.length != 0) {
      Chord.printHeaders()
      chordList.foreach(_.printPretty())
      println()
    } else println("\nNo chords match your search\n")
  }


  /** Formats a NOTE_NAMES string */
  def formatNoteNames(notes: String):String = {
    val noteArr = getNoteArray(notes)
    noteArr.map(_.toLowerCase.capitalize).mkString("-")
  }
}