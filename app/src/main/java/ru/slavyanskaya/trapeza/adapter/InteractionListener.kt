package ru.slavyanskaya.trapeza.adapter

interface InteractionListener {
    fun changeOrder(id: Long, count: Int)
    fun removeFromOrder(id: Long)
}