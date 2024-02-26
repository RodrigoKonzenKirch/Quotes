package com.example.quotes.quotes_list.domain.models

data class QuotesScreenState(
    val myQuotes: List<Quote> = listOf(Quote("", 0, ""))
)