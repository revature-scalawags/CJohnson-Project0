case class Chord (root: String, chordType: String, structure: String, notes: String, frets: String) {

	def toCSVFormat(): String = s"$root;$chordType;$structure;$notes;$frets"

	def printCSVFormat(): Unit = println(toCSVFormat)

}