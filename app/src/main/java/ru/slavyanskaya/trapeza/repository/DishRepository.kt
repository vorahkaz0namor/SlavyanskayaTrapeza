package ru.slavyanskaya.trapeza.repository

import androidx.lifecycle.LiveData
import ru.slavyanskaya.trapeza.dto.Dish
import ru.slavyanskaya.trapeza.dto.OrderedDish

interface DishRepository {
    fun getAllDishes(): LiveData<List<Dish>>
    fun getPresentDishes(): LiveData<List<Dish>>
    fun setDishPresence(dish: Dish)
    fun getOrderedDishes(): LiveData<List<OrderedDish>>?
    fun insertOrderedDish(orderedDish: OrderedDish)
    fun updateOrderedDish(id: Long, count: Int)
    fun removeOrderedDish(id: Long)
}