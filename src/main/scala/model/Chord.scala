package model

import org.bson.types.ObjectId

case class Chord (
	_id: String,
	ROOT: String,
	TYPE: String,
	STRUCTURE: String,
	NOTE_NAMES: String,
	FRET_POSITIONS: String
) {

	def getId(): Int = Integer.parseInt(_id)

	def printCSVFormat(): Unit = println(toCSVFormat)

	def toCSVFormat(): String = s"$ROOT,$TYPE,$STRUCTURE,$NOTE_NAMES,$FRET_POSITIONS"

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

object Chord {
		def printHeaders(): Unit = {
			println("\nROOT \t TYPE \t STRUCTURE \t NOTE_NAMES \t FRET_POSITIONS")
		}
  }