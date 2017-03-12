package com.minimerce.domain.order.item

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class OrderItemRepository() extends BaseRepository[OrderItemTable, OrderItem](TableQuery[OrderItemTable]) {
}
