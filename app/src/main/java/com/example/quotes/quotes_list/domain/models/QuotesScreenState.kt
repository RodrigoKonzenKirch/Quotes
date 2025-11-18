package com.example.quotes.quotes_list.domain.models

data class QuotesScreenState(
    val myQuotes: List<Quote> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)