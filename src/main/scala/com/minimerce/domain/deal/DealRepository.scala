package com.minimerce.domain.deal

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class DealRepository() extends BaseRepository[DealTable, Deal](TableQuery[DealTable]) {
}
