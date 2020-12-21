import org.mongodb.scala.MongoClient
// import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.bson.codecs.Macros._
import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
import org.mongodb.scala.Observable
import org.mongodb.scala.MongoCollection
import org.mongodb.scala.model.Filters.equal
import model.Chord
// import dao.ChordDAO

/** Simple Guitar Chord Library Application
  * 
  */
object ChordLibrary extends App {

  val codecRegistry = fromRegistries(fromProviders(classOf[Chord]), MongoClient.DEFAULT_CODEC_REGISTRY)

  val client = MongoClient()
  val db = client.getDatabase("testdb").withCodecRegistry(codecRegistry)

  val coll: MongoCollection[Chord] = db.getCollection("chords")
  
  private def getResults[T](obs: Observable[T]): Seq[T] = {
    Await.result(obs.toFuture(), Duration(10, SECONDS))
  }

  def getAll: Seq[Chord] = getResults(coll.find())

  def getRoot(root: String): Seq[Chord] = getResults(coll.find(equal("ROOT", root.capitalize)))

  if (args.length != 0) {
    parseArgs(args)
  } else invalidInputNotify()

  // val chordDAO = new ChordDAO(MongoClient())

  /** Parses argument list
    * 
    * @param args argument list
    * @param file CSV file
    */
  def parseArgs(args: Array[String]): Unit = args(0) match {
    case "-a" | "--all" => {
      val test = getAll
      Chord.printHeaders()
      test.foreach(_.printPretty())
    }
    case "-r" | "--root" => {
      if (args.length < 2) println("Enter a Note")
      else {
        val test = getRoot(args(1))
        Chord.printHeaders()
        test.foreach(_.printPretty)
      }
    }
    case "-help" => printHelp()
    case _ => invalidInputNotify()
  }


  /** Notifies the user about invalid input arguments */
  def invalidInputNotify(): Unit = println("Invalid Input")


  /** Prints help */
  def printHelp(): Unit = {
    println("\nUsage: ChordLibrary [--help] <command> [<args>]\n")
    println("This is a list of commands to be used with ChordLibrary:\n")
    println("\t-a\t\tPrint entire library of chords\n")
  }
}