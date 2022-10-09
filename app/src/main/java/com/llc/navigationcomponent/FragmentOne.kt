package com.llc.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.llc.navigationcomponent.databinding.FragmentOneBinding
import com.llc.navigationcomponent.model.ProfileModel

class FragmentOne : Fragment() {

    companion object {
        const val LOGIN_SUCCESSFUL: String = "LOGIN_SUCCESSFUL"
    }

    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var savedStateHandle: SavedStateHandle

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

        /* savedStateHandle= findNavController().previousBackStackEntry!!.savedStateHandle
         savedStateHandle.set(LOGIN_SUCCESSFUL,false)*/

        binding.btnNext.setOnClickListener {

            userViewModel.login(
                name = binding.etName.text.toString(),
                mobileNo = binding.etMobileNo.text.toString(),
                email = binding.etEmail.text.toString(),
                address = binding.etAddress.text.toString()
            ) {
                if (it) {
                    val profileModel = ProfileModel(
                        name = binding.etName.text.toString(),
                        mobileNo = binding.etMobileNo.text.toString(),
                        email = binding.etEmail.text.toString(),
                        address = binding.etAddress.text.toString(),
                        dob = ""
                    )
                    val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(profileModel)
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(requireContext(), "Fields Required!", Toast.LENGTH_LONG).show()
                }
            }
        }

        userViewModel.uiEvent.observe(viewLifecycleOwner) {
            if (it) {
                val profileModel = ProfileModel(
                    name = binding.etName.text.toString(),
                    mobileNo = binding.etMobileNo.text.toString(),
                    email = binding.etEmail.text.toString(),
                    address = binding.etAddress.text.toString(),
                    dob = ""
                )

                val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(profileModel)
                findNavController().navigate(action)
            } else {
                Toast.makeText(requireContext(), "Fields Required!", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnSkip.setOnClickListener {
            //You can replace it with using deep link in your nar graph
            /* val action=FragmentOneDirections.actionFragmentOneToFragmentThree()
             findNavController().navigate(action)*/

            val navigateController = findNavController()
            userViewModel.name.observe(viewLifecycleOwner, Observer { name ->
                if (!name.equals(null)) {
                    navigateController.navigate(R.id.action_fragmentOne_to_fragmentThree)

                } else {
                    navigateController.navigate(R.id.fragmentOne)

                }
            })

            //Using Deep link
            /* val request = NavDeepLinkRequest.Builder
                 .fromUri("android-app://FragmentThree".toUri())
                 .build()
             findNavController().navigate(request)*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}