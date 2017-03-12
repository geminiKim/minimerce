package com.minimerce.domain.order.detail

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class OrderDetailRepository() extends BaseRepository[OrderDetailTable, OrderDetail](TableQuery[OrderDetailTable]) {
}
