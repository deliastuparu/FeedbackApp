package com.pub.feedbackapp.ui.auth.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pub.feedbackapp.BR
import com.pub.feedbackapp.R
import com.pub.feedbackapp.databinding.FragmentRegisterBinding
import com.pub.feedbackapp.databinding.FragmentUsersBinding
import com.pub.feedbackapp.ui.auth.register.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {
    private lateinit var binding: FragmentUsersBinding
    private val viewModel: UsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupScreen()
        subscribeObservers()
    }

    private fun setupScreen() {
        viewModel.user.observe(viewLifecycleOwner) {
            val adapter = UsersAdapter(it.toMutableList())
            binding.usersRv.adapter = adapter
        }
    }

    private fun subscribeObservers() {
        viewModel.goBackEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_usersFragment_to_LoginFragment)
        }
    }
}