package dao

import org.mongodb.scala.Observable
import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.MongoCollection
import org.mongodb.scala.MongoClient
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal
import model.Chord

// trait ChordDAO[T] {

//   def storeResults(obs: Observable[T]): Seq[T]
//   def getAll: Seq[T]
//   def getRoot(root: String): Seq[T]

// }

// class ChordDAO (client: MongoClient) {
//   val codecRegistry = fromRegistries(fromProviders(classOf[Chord]), MongoClient.DEFAULT_CODEC_REGISTRY)
  
//   val db = client.getDatabase("testdb").withCodecRegistry(codecRegistry)

//   val coll: MongoCollection[Chord] = db.getCollection("chords")

//   def storeResults(obs: Observable[Chord]): Seq[Chord] = Await.result(obs.toFuture(), Duration(10, SECONDS))

//   def getAll: Seq[Chord] = storeResults(coll.find())

//   def getRoot(root: String): Seq[Chord] = storeResults(coll.find(equal("ROOT", root.capitalize)))
// }