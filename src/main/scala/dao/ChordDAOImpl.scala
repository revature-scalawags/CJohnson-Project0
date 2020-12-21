package dao

// import org.mongodb.scala.Observable
// import scala.concurrent.Await
// import scala.concurrent.duration.{Duration, SECONDS}
// import org.mongodb.scala.model.Filters.equal
// import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
// import org.mongodb.scala.bson.codecs.Macros._
// import org.mongodb.scala.MongoCollection
// import org.mongodb.scala.MongoClient
// import model.Chord

// class ChordDAOImpl extends ChordDAO[Chord] {

//   protected val codecRegistry = fromRegistries(fromProviders(classOf[Chord]), MongoClient.DEFAULT_CODEC_REGISTRY)

//   val client = MongoClient()
//   val db = client.getDatabase("testdb").withCodecRegistry(codecRegistry)

//   val coll: MongoCollection[Chord] = db.getCollection("chords")

//   override def storeResults(obs: Observable[Chord]): Seq[Chord] = Await.result(obs.toFuture(), Duration(10, SECONDS))

//   override def getAll: Seq[Chord] = {println("this is fine\n\n\n\n\n"); storeResults(coll.find())}

//   override def getRoot(root: String): Seq[Chord] = storeResults(coll.find(equal("ROOT", root.capitalize)))

// }