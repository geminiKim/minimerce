package com.minimerce.module

import com.minimerce.domain.deal.DealRepository
import com.minimerce.domain.deal.option.DealOptionRepository
import com.minimerce.domain.deal.option.item.DealOptionItemRepository
import com.minimerce.domain.item.ItemRepository
import com.minimerce.domain.order.OrderRepository
import com.minimerce.domain.order.detail.OrderDetailRepository
import com.minimerce.domain.order.item.OrderItemRepository

trait RepositoryModule {
	this: Configuration  =>

	val dealRepository = new DealRepository
	val dealOptionRepository = new DealOptionRepository
	val dealOptionItemRepository = new DealOptionItemRepository
	val orderRepository = new OrderRepository
	val orderDetailRepository = new OrderDetailRepository
	val orderItemRepository = new OrderItemRepository
	val itemRepository = new ItemRepository

	def initTable(): Unit = {
		dealRepository.createTable()
		dealOptionRepository.createTable()
		dealOptionItemRepository.createTable()
		orderRepository.createTable()
		orderDetailRepository.createTable()
		orderItemRepository.createTable()
		itemRepository.createTable()
	}
}
