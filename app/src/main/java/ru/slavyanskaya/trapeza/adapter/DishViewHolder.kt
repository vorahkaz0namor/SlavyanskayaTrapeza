package ru.slavyanskaya.trapeza.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.slavyanskaya.trapeza.R
import ru.slavyanskaya.trapeza.databinding.DishCardBinding
import ru.slavyanskaya.trapeza.dto.DishWithOrder

class DishViewHolder(
    private val binding: DishCardBinding,
    private val interactionListener: InteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dish: DishWithOrder) {
        fillingDishCard(dish)
        binding.choose.isChecked = dish.isOrdered
        setupListeners(dish)
    }

    fun bindOrder(dish: DishWithOrder) {
        fillingDishCard(dish)
        binding.choose.setIconResource(R.drawable.ic_remove_dish)
        setupListeners(dish)
    }

    private fun fillingDishCard(dish: DishWithOrder) {
        binding.apply {
            dishName.text = dish.name
            quantity.text = dish.quantity.toString()
            cost.text = dish.cost.toString()
            count.text = dish.count.toString()
        }
    }

    private fun setupListeners(dish: DishWithOrder) {
        binding.apply {
            choose.setOnClickListener {
                interactionListener.apply {
                    if (dish.isOrdered)
                        removeFromOrder(dish.id)
                    else {
                        val newCount = count.text.toString().toInt()
                        if (newCount > 0)
                            changeOrder(dish.id, newCount)
                        else
                            choose.isChecked = false
                    }
                }
            }
            increaseCount.setOnClickListener {
                interactionListener.changeOrder(
                        dish.id,
                        count.text.toString().toInt() + 1
                    )
            }
            decreaseCount.setOnClickListener {
                interactionListener.changeOrder(
                        dish.id,
                        count.text.toString().toInt() - 1
                    )
            }
        }
    }
}