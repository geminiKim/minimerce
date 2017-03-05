package com.minimerce.database

import org.slf4j.LoggerFactory

trait H2 extends DBComponent {
  val logger = LoggerFactory.getLogger(this.getClass)

  val driver = slick.driver.H2Driver

  import driver.api._

  val db: Database = {
    logger.info("Creating test connection ..................................")
    Database.forURL(url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
   }
}
