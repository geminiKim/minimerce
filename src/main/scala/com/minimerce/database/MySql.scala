package com.minimerce.database

import slick.driver.MySQLDriver

trait MySqlComponent extends DBComponent {

  val driver = MySQLDriver

  import driver.api._

  val db: Database = MySqlConfig.connectionPool

}

private[database] object MySqlConfig {

  import slick.driver.MySQLDriver.api._

  val connectionPool = Database.forConfig("mysql")

}
