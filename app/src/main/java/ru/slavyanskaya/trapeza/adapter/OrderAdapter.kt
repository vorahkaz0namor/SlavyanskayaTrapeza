package ru.slavyanskaya.trapeza.adapter

class OrderAdapter(
    interactionListener: InteractionListener
): DishAdapter(interactionListener) {
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bindOrder(getItem(position))
    }
}