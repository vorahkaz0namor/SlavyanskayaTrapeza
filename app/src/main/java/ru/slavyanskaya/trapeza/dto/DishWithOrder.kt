package ru.slavyanskaya.trapeza.dto

data class DishWithOrder(
    val id: Long,
    val name: String,
    val type: Int,
    val quantity: Long,
    val cost: Long,
    val count: Int,
    val isOrdered: Boolean
)
