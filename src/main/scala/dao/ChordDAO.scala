package dao

import org.mongodb.scala.Observable

trait ChordDAO[T] {
  
  def storeResults(obs: Observable[T]): Seq[T]
  def getAll: Seq[T]
  def getRoot(root: String): Seq[T]
}