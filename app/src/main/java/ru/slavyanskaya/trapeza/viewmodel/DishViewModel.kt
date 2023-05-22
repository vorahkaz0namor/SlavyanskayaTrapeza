package ru.slavyanskaya.trapeza.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import ru.slavyanskaya.trapeza.db.AppDb
import ru.slavyanskaya.trapeza.dto.DishWithOrder
import ru.slavyanskaya.trapeza.dto.OrderedDish
import ru.slavyanskaya.trapeza.repository.*

class DishViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DishRepository =
        DishRepositoryImpl(AppDb.getInstance(application).dishDao())
    val dishes = repository.getAllDishes()
    val order = repository.getOrderedDishes()
    val menu = repository.getPresentDishes()

    fun menuWithOrder() =
            menu.value?.map {
                DishWithOrder(
                    id = it.id,
                    name = it.name,
                    type = it.type,
                    quantity = it.quantity,
                    cost = it.cost,
                    count = orderedDishCount(it.id),
                    isOrdered = dishInOrder(it.id)
                )
            }

    fun orderedDishes() = menuWithOrder()?.filter { it.isOrdered }

    private fun dishInOrder(id: Long) = order?.value?.find { it.id == id } != null

    private fun orderedDishCount(id: Long) = order?.value?.find { it.id == id }?.count ?: 0

    fun changeOrder(id: Long, count: Int) {
        // limitCount - доступное количество порций заказываемого блюда
        val limitCount = 9
        if (count in 0 .. limitCount) {
            if (dishInOrder(id)) {
                if (count == 0)
                    repository.removeOrderedDish(id)
                else
                    repository.updateOrderedDish(id, count)
            }
            else
                repository.insertOrderedDish(OrderedDish(id, count))
        }
        Log.d("MENU WITH ORDER", "all dishes count = ${menuWithOrder()?.size}")
    }

    fun removeOrderedDish(id: Long) = repository.removeOrderedDish(id)
}