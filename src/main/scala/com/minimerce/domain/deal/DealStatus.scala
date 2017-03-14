package com.minimerce.domain.deal

/**
  * Created by gemini on 14/03/2017.
  */
object DealStatus extends Enumeration {
  type DealStatus = Value
  val READY, SALE, END, SOLD_OUT = DealStatus
}
