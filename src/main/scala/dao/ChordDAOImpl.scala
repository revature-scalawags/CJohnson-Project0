package dao

import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.Observable
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, SECONDS}

import model.Chord
import utilities.DAOUtility

class ChordDAOImpl extends ChordDAO[Chord] with DAOUtility {

  def getResults(obs: Observable[Chord]): Seq[Chord] = Await.result(obs.toFuture(), Duration(10, SECONDS)).sortWith(_.getId<_.getId())
  def getAll: Seq[Chord] = getResults(coll.find())
  def getRoot(root: String): Seq[Chord] = getResults(coll.find(equal("ROOT", root.capitalize)))
}