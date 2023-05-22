package ru.slavyanskaya.trapeza.dto

data class Dish(
    val id: Long,
    val name: String,
    val type: Int,
    val quantity: Long,
    val cost: Long,
    val isPresent: Boolean = false
)