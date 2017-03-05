package com.minimerce.database

import slick.driver.JdbcProfile

trait DBComponent {
  
  val driver: JdbcProfile

  import driver.api._

  val db: Database

}
