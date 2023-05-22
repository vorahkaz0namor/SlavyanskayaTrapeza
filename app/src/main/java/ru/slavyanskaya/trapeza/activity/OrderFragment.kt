package ru.slavyanskaya.trapeza.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.slavyanskaya.trapeza.R
import ru.slavyanskaya.trapeza.adapter.DishAdapter
import ru.slavyanskaya.trapeza.adapter.InteractionListenerImpl
import ru.slavyanskaya.trapeza.adapter.OrderAdapter
import ru.slavyanskaya.trapeza.databinding.FragmentOrderBinding
import ru.slavyanskaya.trapeza.util.viewBinding
import ru.slavyanskaya.trapeza.viewmodel.DishViewModel

class OrderFragment : Fragment(R.layout.fragment_order) {
    private val binding by viewBinding(FragmentOrderBinding::bind)
    private val viewModel: DishViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )
    private lateinit var adapter: OrderAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribe()
    }

    private fun initViews() {
        adapter = OrderAdapter(InteractionListenerImpl(viewModel))
        binding.orderedDishes.adapter = adapter
    }

    private fun subscribe() {
        viewModel.apply {
            menu.observe(viewLifecycleOwner) {
                adapter.submitList(orderedDishes())
            }
            order?.observe(viewLifecycleOwner) {
                adapter.submitList(orderedDishes())
            }
        }
    }
}