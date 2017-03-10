package com.minimerce.domain.deal

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class DealOptionItemRepository() extends BaseRepository[DealOptionItemTable, DealOptionItem](TableQuery[DealOptionItemTable]) {
}
