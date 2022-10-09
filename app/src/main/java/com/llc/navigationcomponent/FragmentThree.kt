package com.llc.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.llc.navigationcomponent.databinding.FragmentOneBinding
import com.llc.navigationcomponent.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {

    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!

    private val userViewModel:UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtFrg.text="You are authenticated.!"

        binding.btnBackFrag.setOnClickListener {

            findNavController().navigate(R.id.fragmentOne)
        }




    }


}