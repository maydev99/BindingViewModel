package com.bombadu.bindingviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bombadu.bindingviewmodel.databinding.FragmentOneBinding


class FragmentOne : Fragment() {
    lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(layoutInflater, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = MyViewModelFactory(application)

        val myViewModel =
            ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)

        binding.myViewModel = myViewModel

        binding.lifecycleOwner = this

      /*  myViewModel.navigateToFragmentTwo.observe(viewLifecycleOwner, Observer { name ->
            name.let {
                this.findNavController()
                    .navigate(FragmentOneDirections.actionFragmentOneToFragmentTwo(name))
            }
            Log.i("TAG", "CLICK")


            *//* name ->
            name?.let {
                this.findNavController().navigate(
                    FragmentOneDirections.actionFragmentOneToFragmentTwo()
                )
            }*//*
        })*/

        binding.saveButton.setOnClickListener { view ->
            val name = binding.editTextTextPersonName.text.toString()
            val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(name)
            view.findNavController().navigate(action)
        }


        return binding.root
    }

}