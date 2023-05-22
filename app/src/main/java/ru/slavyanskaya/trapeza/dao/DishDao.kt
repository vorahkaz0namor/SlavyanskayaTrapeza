package ru.slavyanskaya.trapeza.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.slavyanskaya.trapeza.entity.DishEntity
import ru.slavyanskaya.trapeza.entity.OrderedDishEntity

@Dao
interface DishDao {
    @Query("SELECT * FROM DishEntity")
    fun getAllDishes(): LiveData<List<DishEntity>>

    @Query("SELECT * FROM DishEntity WHERE isPresent = 1")
    fun getPresentDishes(): LiveData<List<DishEntity>>

    @Query("UPDATE DishEntity SET isPresent = :isPresent WHERE id = :id")
    fun updateDishPresence(id: Long, isPresent: Boolean)

    fun setDishPresence(dish: DishEntity) =
        updateDishPresence(dish.id, dish.isPresent)

    @Query("SELECT * FROM OrderedDishEntity")
    fun getOrderedDishes(): LiveData<List<OrderedDishEntity>>?

    @Insert
    fun insertOrderedDish(orderedDish: OrderedDishEntity)

    @Query("UPDATE OrderedDishEntity SET count = :count WHERE id = :id")
    fun updateOrderedDishById(id: Long, count: Int)

    @Query("DELETE FROM OrderedDishEntity WHERE id = :id")
    fun removeOrderedDish(id: Long)
}