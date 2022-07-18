package com.zjl.models

import kotlinx.serialization.Serializable

@Serializable
data class OrderItem(val item: String, val amount: Int, val price: Double)

@Serializable
data class Order(val number: String, val contents: String)


val orderStorage = kotlin.collections.listOf<Order>(
        Order("2020-04-06-01", "苹果"),
        Order("2020-04-03-01", "西瓜")
)