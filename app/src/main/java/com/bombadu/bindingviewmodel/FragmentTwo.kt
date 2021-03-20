package com.bombadu.bindingviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bombadu.bindingviewmodel.databinding.FragmentTwoBinding
import kotlinx.coroutines.newSingleThreadContext


class FragmentTwo : Fragment() {
    lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(layoutInflater, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = MyViewModelFactory(application)

        val myViewModel =
            ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)

        val args: FragmentTwoArgs by navArgs()
        val name = args.name
        binding.textView.text = name

        binding.lifecycleOwner = this


        return binding.root
    }

}