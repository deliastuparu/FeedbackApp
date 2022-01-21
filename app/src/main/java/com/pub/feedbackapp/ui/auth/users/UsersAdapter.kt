package com.pub.feedbackapp.ui.auth.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pub.feedbackapp.databinding.LayoutFeedbackBinding
import com.pub.feedbackapp.databinding.LayoutUserBinding
import com.pub.feedbackapp.models.Feedback
import com.pub.feedbackapp.models.User
import com.pub.feedbackapp.utils.DataAdapter
import com.pub.feedbackapp.utils.ViewHolderBindable



class UsersAdapter(
    data: MutableList<User> = mutableListOf(),
    private var interaction: Interaction? = null
) : DataAdapter<User>(data) {

    //region Interaction

    interface Interaction {

    }

    //endregion

    //region RecyclerView Implementation

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //endregion


    //region ViewHolder

    private inner class ViewHolder(private val binding: LayoutUserBinding) : RecyclerView.ViewHolder(binding.root),
        ViewHolderBindable {

        override fun bind(position: Int) {
            binding.surname.text = data[position].name
        }
    }

    //endregion
}