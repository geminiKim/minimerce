package com.minimerce.domain.item

import java.sql.Timestamp

import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class Item(id: Long, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class ItemTable(tag: Tag) extends BaseTable[Item](tag, "item") {
  def * = (id, createdAt, updatedAt) <> (Item.tupled, Item.unapply)
}