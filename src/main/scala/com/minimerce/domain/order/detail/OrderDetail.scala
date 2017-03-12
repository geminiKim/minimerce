package com.minimerce.domain.order.detail

import java.sql.Timestamp

import com.minimerce.domain.{BaseDomain, BaseTable}
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag


case class OrderDetail(id: Long, createdAt: Timestamp, updatedAt: Timestamp) extends BaseDomain

class OrderDetailTable(tag: Tag) extends BaseTable[OrderDetail](tag, "orderDetail") {
  def * = (id, createdAt, updatedAt) <> (OrderDetail.tupled, OrderDetail.unapply)
}