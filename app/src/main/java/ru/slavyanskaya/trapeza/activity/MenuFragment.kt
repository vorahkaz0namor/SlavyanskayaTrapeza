package ru.slavyanskaya.trapeza.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.allViews
import androidx.core.view.children
import androidx.fragment.app.viewModels
import ru.slavyanskaya.trapeza.R
import ru.slavyanskaya.trapeza.adapter.DishAdapter
import ru.slavyanskaya.trapeza.adapter.InteractionListenerImpl
import ru.slavyanskaya.trapeza.databinding.FragmentMenuBinding
import ru.slavyanskaya.trapeza.util.viewBinding
import ru.slavyanskaya.trapeza.viewmodel.DishViewModel

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private val binding by viewBinding(FragmentMenuBinding::bind)
    private val viewModel: DishViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )
    private lateinit var adapter: DishAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribe()
    }

    private fun initViews() {
        adapter = DishAdapter(InteractionListenerImpl(viewModel))
        binding.dishes.adapter = adapter
    }

    private fun subscribe() {
        viewModel.apply {
            menu.observe(viewLifecycleOwner) {
                adapter.submitList(menuWithOrder())
                Log.d("IN 'MENU' OBSERVE", "dishes quantity = ${menuWithOrder()?.size}")
            }
            order?.observe(viewLifecycleOwner) {
                adapter.submitList(menuWithOrder())
                Log.d("IN 'ORDER' OBSERVE", "dishes quantity = ${menuWithOrder()?.size}")
            }
        }
    }
}