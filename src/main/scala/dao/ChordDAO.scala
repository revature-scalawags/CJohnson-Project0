package dao

import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.MongoClient
import org.mongodb.scala.MongoCollection
import org.mongodb.scala.Observable

import model.Chord

trait ChordDAO[T] {
  val codecRegistry = fromRegistries(fromProviders(classOf[Chord]), MongoClient.DEFAULT_CODEC_REGISTRY)
  val client = MongoClient()
  val db = client.getDatabase("testdb").withCodecRegistry(codecRegistry)
  val coll: MongoCollection[Chord] = db.getCollection("chords")

  def storeResults(obs: Observable[T]): Seq[T]
  def getAll: Seq[T]
  def getRoot(root: String): Seq[T]
}