package ru.slavyanskaya.trapeza.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.slavyanskaya.trapeza.dto.Dish

@Entity
data class DishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val type: Int,
    val quantity: Long,
    val cost: Long,
    val isPresent: Boolean = false
) {
    fun toDto() =
        Dish( id, name, type, quantity, cost, isPresent )

    companion object {
        fun fromDto(dtoDish: Dish) =
            DishEntity(
                dtoDish.id,
                dtoDish.name,
                dtoDish.type,
                dtoDish.quantity,
                dtoDish.cost,
                dtoDish.isPresent
            )
    }
}
