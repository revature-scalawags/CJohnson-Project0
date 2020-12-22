package dao

import org.mongodb.scala.model.Filters.{or, equal}
import org.mongodb.scala.Observable
import scala.concurrent.Await

import model.Chord
import utilities.DBUtility


/** Inherits values from DBUtility trait and implements functions from ChordDAO trait */
class ChordDAOImpl extends ChordDAO[Chord] with DBUtility {

  
  /** Gathers results from a query, sorts them by id and puts them in a Sequence of Chord objects */
  def getResults(obs: Observable[Chord]): Seq[Chord] = Await.result(obs.toFuture(), duration).sortWith(_.getId()<_.getId())
  

  /** Query returns all Chord objects in the database as a Sequence */
  def getAll: Seq[Chord] = getResults(coll.find())
  

  /** Query returns all Chord objects built from a user-specified root note, returned a Sequence */
  def getByRoot(root: String): Seq[Chord] = getResults(coll.find(equal("ROOT", root.capitalize)))


  /** Inserts Chord object into the database */
  def insert(chord: Chord): Unit = {
    Await.result(coll.insertOne(chord).toFuture(), duration)
  }
}