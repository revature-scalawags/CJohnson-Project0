package utilities

import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.MongoClient
import org.mongodb.scala.MongoCollection

import model.Chord

trait DBUtility {
  val codecRegistry = fromRegistries(fromProviders(classOf[Chord]), MongoClient.DEFAULT_CODEC_REGISTRY)
  val client = MongoClient()
  val db = client.getDatabase("chordlib").withCodecRegistry(codecRegistry)
  val coll: MongoCollection[Chord] = db.getCollection("chords")
}
