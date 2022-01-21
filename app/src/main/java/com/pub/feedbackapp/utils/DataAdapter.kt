package com.pub.feedbackapp.utils

import androidx.recyclerview.widget.RecyclerView

/**
 * Abstract class for RecyclerViewAdapter.
 *
 * This class provide implement commons behaviour of a RecyclerViewAdapter
 */
abstract class DataAdapter<T>(
    protected val data: MutableList<T> = mutableListOf()
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Used to update adapter data.
     */
    fun updateData(data: List<T>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolderBindable)?.bind(position)
    }

    override fun getItemCount(): Int = data.size
}