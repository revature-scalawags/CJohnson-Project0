package model

import org.scalatest.FunSuite

class ChordTest extends FunSuite {

  val c = Chord("0", "A", "maj", "1-3-5", "A-C#-E", "x-0-2-2-2-0")

  test("new Chord objects are properly instantiated") {
    assert(c._id == "0")
    assert(c.ROOT == "A")
    assert(c.TYPE == "maj")
    assert(c.STRUCTURE == "1-3-5")
    assert(c.NOTE_NAMES == "A-C#-E")
    assert(c.FRET_POSITIONS == "x-0-2-2-2-0")
  }

  test("getID returns the proper id of the Chord object") {
    assert(c.getId() == 0)
  }

  test("toCSVFormat returns a string with proper csv formatting") {
    assert(c.toCSVFormat() == "0,A,maj,1-3-5,A-C#-E,x-0-2-2-2-0\n")
  }

  test("spacer returns the proper spacing string") {
    //def spacer(text: String): String = if (text.length < 6) "\t\t" else "\t"
    assert(c.spacer("test-string") == "\t")
    assert(c.spacer("test") == "\t\t")
  }
}