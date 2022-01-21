package com.pub.feedbackapp.ui.main.feedbacklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pub.feedbackapp.databinding.LayoutFeedbackBinding
import com.pub.feedbackapp.models.Feedback
import com.pub.feedbackapp.utils.DataAdapter
import com.pub.feedbackapp.utils.ViewHolderBindable


class FeedbackAdapter(
    data: MutableList<Feedback> = mutableListOf(),
    private var interaction: Interaction? = null
) : DataAdapter<Feedback>(data) {

    //region Interaction

    interface Interaction {

    }

    //endregion

    //region RecyclerView Implementation

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutFeedbackBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //endregion


    //region ViewHolder

    private inner class ViewHolder(private val binding: LayoutFeedbackBinding) : RecyclerView.ViewHolder(binding.root),
        ViewHolderBindable {

    }

    //endregion
}