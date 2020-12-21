package dao

import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.Observable
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, SECONDS}

import model.Chord
import utilities.DAOUtility

class ChordDAOImpl extends ChordDAO[Chord] with DAOUtility {

  def storeResults(obs: Observable[Chord]): Seq[Chord] = Await.result(obs.toFuture(), Duration(10, SECONDS))
  def getAll: Seq[Chord] = storeResults(coll.find())
  def getRoot(root: String): Seq[Chord] = storeResults(coll.find(equal("ROOT", root.capitalize)))
}