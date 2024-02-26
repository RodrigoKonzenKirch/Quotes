package com.example.quotes.quotes_list.domain.models

data class Quotes(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)