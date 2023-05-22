package ru.slavyanskaya.trapeza.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.slavyanskaya.trapeza.R
import ru.slavyanskaya.trapeza.databinding.FragmentStartBinding
import ru.slavyanskaya.trapeza.util.viewBinding

class StartFragment : Fragment(R.layout.fragment_start) {
    private val binding by viewBinding(FragmentStartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.apply {
            revocation.setOnClickListener {

            }
            about.setOnClickListener {

            }
        }
    }

}