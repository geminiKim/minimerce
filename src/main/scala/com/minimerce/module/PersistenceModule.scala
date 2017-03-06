package com.minimerce.module

import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

trait PersistenceModule {
	this: Configuration  =>

	private val dbConfig : DatabaseConfig[JdbcProfile]  = DatabaseConfig.forConfig("mysql")
	implicit val profile: JdbcProfile = dbConfig.driver
	implicit val db: JdbcProfile#Backend#Database = dbConfig.db
}
