package com.minimerce.domain.deal.option

import com.minimerce.domain.BaseRepository
import slick.driver.MySQLDriver.api._

class DealOptionRepository() extends BaseRepository[DealOptionTable, DealOption](TableQuery[DealOptionTable]) {
}
