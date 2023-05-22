package ru.slavyanskaya.trapeza.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.slavyanskaya.trapeza.dao.DishDao
import ru.slavyanskaya.trapeza.dto.Dish
import ru.slavyanskaya.trapeza.dto.OrderedDish
import ru.slavyanskaya.trapeza.entity.DishEntity
import ru.slavyanskaya.trapeza.entity.OrderedDishEntity

class DishRepositoryImpl(
    private val dao: DishDao
) : DishRepository {
    override fun getAllDishes(): LiveData<List<Dish>> =
        Transformations.map(dao.getAllDishes()) { list ->
            list.map { it.toDto() }
        }

    override fun getPresentDishes(): LiveData<List<Dish>> =
        Transformations.map(dao.getPresentDishes()) { list ->
            list.map { it.toDto() }
        }

    override fun setDishPresence(dish: Dish) {
        dao.setDishPresence(DishEntity.fromDto(dish))
    }

    override fun getOrderedDishes(): LiveData<List<OrderedDish>>? {
        val orderedDishes = dao.getOrderedDishes()
        return if (orderedDishes != null)
                    Transformations.map(orderedDishes) { list ->
                        list.map { it.toDto() }
                    }
        else
            null
    }

    override fun insertOrderedDish(orderedDish: OrderedDish) {
        dao.insertOrderedDish(OrderedDishEntity.fromDto(orderedDish))
    }

    override fun updateOrderedDish(id: Long, count: Int) {
        dao.updateOrderedDishById(id, count)
    }

    override fun removeOrderedDish(id: Long) {
        dao.removeOrderedDish(id)
    }
}