package ru.slavyanskaya.trapeza.adapter

import ru.slavyanskaya.trapeza.viewmodel.DishViewModel

class InteractionListenerImpl(
    private val viewModel: DishViewModel
) : InteractionListener {
    override fun changeOrder(id: Long, count: Int) {
        viewModel.changeOrder(id, count)
    }

    override fun removeFromOrder(id: Long) {
        viewModel.removeOrderedDish(id)
    }
}