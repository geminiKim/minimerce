package com.minimerce.domain.deal

import java.sql.Timestamp

import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class DealOptionItem(id: Long, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class DealOptionItemTable(tag: Tag) extends BaseTable[DealOptionItem](tag, "order") {
  def * = (id, createdAt, updatedAt) <> (DealOptionItem.tupled, DealOptionItem.unapply)
}