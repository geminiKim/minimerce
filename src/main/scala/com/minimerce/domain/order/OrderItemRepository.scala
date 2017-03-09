package com.minimerce.domain.order

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class OrderItemRepository() extends BaseRepository[OrderItemTable, OrderItem](TableQuery[OrderItemTable]) {
}
