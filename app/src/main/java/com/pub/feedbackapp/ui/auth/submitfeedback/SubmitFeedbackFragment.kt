package com.pub.feedbackapp.ui.auth.submitfeedback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pub.feedbackapp.BR
import com.pub.feedbackapp.R
import com.pub.feedbackapp.databinding.FragmentSubmitFeedbackBinding
import com.pub.feedbackapp.databinding.FragmentUsersBinding
import com.pub.feedbackapp.ui.auth.users.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SubmitFeedbackFragment : Fragment(R.layout.fragment_submit_feedback) {
    private lateinit var binding: FragmentSubmitFeedbackBinding
    private val viewModel: SubmitFeedbackViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubmitFeedbackBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.goBackEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_submitFeedbackFragment_to_usersFragment)
        }
    }
}