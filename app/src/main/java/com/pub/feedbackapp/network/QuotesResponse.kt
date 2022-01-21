package com.pub.feedbackapp.network

import com.pub.feedbackapp.models.Quote

data class QuotesResponse(
    val quotes: List<Quote>
)