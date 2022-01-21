package com.pub.feedbackapp.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pub.feedbackapp.R
import com.pub.feedbackapp.BR
import com.pub.feedbackapp.databinding.FragmentLoginBinding
import com.pub.feedbackapp.databinding.FragmentRegisterBinding
import com.pub.feedbackapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.registerEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
        }
    }
}