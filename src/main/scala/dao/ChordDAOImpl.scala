package dao

import org.mongodb.scala.model.Filters.{or, equal}
import org.mongodb.scala.Observable
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, SECONDS}

import model.Chord
import utilities.DBUtility

class ChordDAOImpl extends ChordDAO[Chord] with DBUtility {

  def getResults(obs: Observable[Chord]): Seq[Chord] = Await.result(obs.toFuture(), Duration(10, SECONDS)).sortWith(_.getId<_.getId())
  def getAll: Seq[Chord] = getResults(coll.find())
  def getByRoot(root: String): Seq[Chord] = getResults(coll.find(equal("ROOT", root.capitalize)))
}