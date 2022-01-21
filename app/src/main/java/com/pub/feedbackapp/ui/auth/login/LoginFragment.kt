package com.pub.feedbackapp.ui.auth.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pub.feedbackapp.BR
import com.pub.feedbackapp.R
import com.pub.feedbackapp.databinding.FragmentLoginBinding
import com.pub.feedbackapp.ui.auth.AuthListener
import com.pub.feedbackapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var authListener: AuthListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            authListener = context as AuthListener
        } catch (e: ClassCastException) {
        }
    }

    private fun subscribeObservers() {
        viewModel.showRegisterEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }

        viewModel.showUsersEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_LoginFragment_to_usersFragment)
        }

        viewModel.succesLoginEvent.observe(viewLifecycleOwner) {
            authListener.onSuccessLogin(it)
        }
    }
}