package com.minimerce.domain.order

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class OrderRepository() extends BaseRepository[OrderTable, Order](TableQuery[OrderTable]) {
}
