package com.llc.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.llc.navigationcomponent.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentTwoArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* val navController=findNavController()
         val currentBackStackEntry = navController.currentBackStackEntry!!
         val savedStateHandle = currentBackStackEntry.savedStateHandle
         savedStateHandle.getLiveData<Boolean>(FragmentOne.LOGIN_SUCCESSFUL)
             .observe(currentBackStackEntry, Observer { success ->
                 if (!success) {
                     val startDestination = navController.graph.startDestinationId
                     val navOptions = NavOptions.Builder()
                         .setPopUpTo(startDestination, true)
                         .build()
                     navController.navigate(startDestination, null, navOptions)
                 }
             })*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = args.profile.name
        binding.tvMobileNo.text = args.profile.mobileNo
        binding.tvEmail.text = args.profile.email
        binding.tvAddress.text = args.profile.address



        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.fragmentOne)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}