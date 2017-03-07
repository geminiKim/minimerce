package com.minimerce.domain

import java.sql.Timestamp

import slick.driver.MySQLDriver.api._
import slick.lifted.Tag

abstract class BaseTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def createdAt = column[Timestamp]("created_at", O.SqlType("timestamp default now()"))
  def updatedAt = column[Timestamp]("updated_at", O.SqlType("timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"))
}

trait BaseDomain {
  val id : Long
  def isValid : Boolean = true
}
