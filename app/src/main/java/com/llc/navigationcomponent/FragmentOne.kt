package com.llc.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.llc.navigationcomponent.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val name=binding.etName.text.toString()
            val mobileNo=binding.etMobileNo.text.toString()
            val email=binding.etEmail.text.toString()
            val address=binding.etAddress.text.toString()

            val action=FragmentOneDirections.actionFragmentOneToFragmentTwo(name,mobileNo,email,address)

            findNavController().navigate(action)
        }
        binding.btnSkip.setOnClickListener {
            val action=FragmentOneDirections.actionFragmentOneToFragmentThree()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}