package ru.slavyanskaya.trapeza.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.slavyanskaya.trapeza.dto.DishWithOrder

class DishItemCallback : DiffUtil.ItemCallback<DishWithOrder>() {

    override fun areItemsTheSame(oldItem: DishWithOrder, newItem: DishWithOrder) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DishWithOrder, newItem: DishWithOrder) =
        oldItem == newItem

}