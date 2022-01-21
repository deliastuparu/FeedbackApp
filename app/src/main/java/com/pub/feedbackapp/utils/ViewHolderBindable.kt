package com.pub.feedbackapp.utils

/**
 * Interface for RecyclerView ViewHolders.
 *
 * This interface will be implemented by all ViewHolders.
 * One of ViewHolders binding behaviour will be override.
 */
interface ViewHolderBindable {
    /**
     * Optional methods used for binding.
     */
    fun bind() {}

    /**
     * Optional methods used for binding.
     */
    fun bind(position: Int) {}
}