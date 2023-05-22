package ru.slavyanskaya.trapeza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.slavyanskaya.trapeza.databinding.DishCardBinding
import ru.slavyanskaya.trapeza.dto.DishWithOrder

open class DishAdapter(
    private val interactionListener: InteractionListener
) : ListAdapter<DishWithOrder, DishViewHolder>(DishItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = DishCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DishViewHolder( binding, interactionListener )
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) =
        holder.bind(getItem(position))
}