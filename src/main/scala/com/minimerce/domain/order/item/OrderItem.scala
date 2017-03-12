package com.minimerce.domain.order.item

import java.sql.Timestamp

import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class OrderItem(id: Long, name: String, desc: String, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class OrderItemTable(tag: Tag) extends BaseTable[OrderItem](tag, "orderItem") {
  def name = column[String]("name")
  def description = column[String]("description")
  def * = (id, name, description, createdAt, updatedAt) <> (OrderItem.tupled, OrderItem.unapply)
}