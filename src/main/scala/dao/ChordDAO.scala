package dao

import org.mongodb.scala.Observable


/** ChordDAO functions as an interface for the ChordDAOImpl class */
trait ChordDAO[T] {
  def getResults(obs: Observable[T]): Seq[T]
  def getAll: Seq[T]
  def getByRoot(root: String): Seq[T]
  def insert(chord: T): Unit
  def delete(chord: T): Unit
  def getByFrets(frets: String): Seq[T]
}