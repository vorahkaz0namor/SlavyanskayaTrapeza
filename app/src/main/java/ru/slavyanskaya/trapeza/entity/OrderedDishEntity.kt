package ru.slavyanskaya.trapeza.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.slavyanskaya.trapeza.dto.OrderedDish

@Entity
data class OrderedDishEntity(
    @PrimaryKey
    val id: Long,
    val count: Int
) {
    fun toDto() = OrderedDish( id, count )

    companion object {
        fun fromDto(dtoOrderedDish: OrderedDish) =
            OrderedDishEntity( dtoOrderedDish.id, dtoOrderedDish.count )
    }
}