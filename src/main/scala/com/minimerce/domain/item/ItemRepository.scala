package com.minimerce.domain.item

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class ItemRepository() extends BaseRepository[ItemTable, Item](TableQuery[ItemTable]) {
}
