package com.minimerce.domain

import java.sql.Timestamp

import slick.driver.MySQLDriver.api._
import slick.lifted.Tag

abstract class BaseTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def createdAt = column[Timestamp]("created_at")
  def updatedAt = column[Timestamp]("updated_at")
}

trait BaseDomain {
  val id : Long
  def isValid : Boolean = true
}
