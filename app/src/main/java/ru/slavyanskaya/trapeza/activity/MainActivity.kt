package ru.slavyanskaya.trapeza.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ru.slavyanskaya.trapeza.R
import ru.slavyanskaya.trapeza.databinding.ActivityMainBinding
import ru.slavyanskaya.trapeza.viewmodel.DishViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: DishViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.order?.observe(this) {
            binding.ordering.text =
                getString(R.string.order, it?.size ?: 0)
        }
        setupListeners()
    }

    private fun setupListeners() {
        binding.apply {
            homeButton.setOnClickListener {
                findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.nav_main)
                menu.isClickable = true
                ordering.isClickable = true
            }
            menu.setOnClickListener {
                findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.menuFragment)
                it.isClickable = false
                ordering.isClickable = true
            }
            ordering.setOnClickListener {
                findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.orderFragment)
                it.isClickable = false
                menu.isClickable = true
            }
        }
    }
}