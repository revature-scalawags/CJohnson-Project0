package model

import org.bson.types.ObjectId


/** Defines Chord fields and methods */
case class Chord (
	_id: String,
	ROOT: String,
	TYPE: String,
	STRUCTURE: String,
	NOTE_NAMES: String,
	FRET_POSITIONS: String
) {

	/** Returns Chord objects id, parsed to an Integer value */
	def getId(): Int = Integer.parseInt(_id)


	/** Prints a Chord in CSV format to the standard output */
	def printCSVFormat(): Unit = println(toCSVFormat())


	/** Returns a string representing the Chord object in CSV format */
	def toCSVFormat(): String = s"$ROOT,$TYPE,$STRUCTURE,$NOTE_NAMES,$FRET_POSITIONS"


	/** Formats and prints a Chord object to standard output */
	def printPretty(): Unit = {
		println(s"$ROOT \t $TYPE \t $STRUCTURE ${spacer(STRUCTURE)} $NOTE_NAMES ${spacer(NOTE_NAMES)} ${FRET_POSITIONS}")
	}


	/** Used to format the data output
    *
    * @param text String data from db collection
    * @return A string containing the appropriate number of tab characters
    */
	def spacer(text: String): String = if (text.length < 6) "\t\t" else "\t"
}


/** Companion object to Chord class */
object Chord {

	/** Prints the Chord class's field names to standard output */
	def printHeaders(): Unit = {
		println("\nROOT \t TYPE \t STRUCTURE \t NOTE_NAMES \t FRET_POSITIONS")
	}
}