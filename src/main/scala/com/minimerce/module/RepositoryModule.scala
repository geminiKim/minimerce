package com.minimerce.module

import com.minimerce.domain.deal.DealRepository

trait RepositoryModule {
	this: Configuration  =>

	val dealRepository = new DealRepository

	def initTable(): Unit = {
		dealRepository.createTable()
	}
}
