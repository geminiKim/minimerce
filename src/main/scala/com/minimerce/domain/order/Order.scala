package com.minimerce.domain.order

import java.sql.Timestamp

import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class Order(id: Long, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class OrderTable(tag: Tag) extends BaseTable[Order](tag, "order") {
  def userId = column[String]("user_id")
  def title = column[String]("title")
  def price = column[String]("price")
  def dealIds = column[String]("dealIds")
  def cartIds = column[String]("cartIds")
  def * = (id, createdAt, updatedAt) <> (Order.tupled, Order.unapply)
}