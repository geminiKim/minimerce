package com.minimerce.domain.deal

import java.sql.Timestamp

import com.minimerce.domain.deal.DealStatus.DealStatus
import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class Deal(id: Long, name: String, desc: String, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class DealTable(tag: Tag) extends BaseTable[Deal](tag, "deal") {
  def name = column[String]("name")
  def description = column[String]("description")
  def status = column[DealStatus]("status")
  def * = (id, name, description, createdAt, updatedAt) <> (Deal.tupled, Deal.unapply)
}