package com.minimerce.domain.deal

import java.sql.Timestamp

import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class DealOption(id: Long, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class DealOptionTable(tag: Tag) extends BaseTable[DealOption](tag, "dealOption") {
  def * = (id, createdAt, updatedAt) <> (DealOption.tupled, DealOption.unapply)
}