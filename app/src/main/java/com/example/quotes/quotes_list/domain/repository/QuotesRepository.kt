package com.example.quotes.quotes_list.domain.repository

import com.example.quotes.quotes_list.domain.models.Quotes

interface QuotesRepository {
    suspend fun getQuotes(): Quotes?
}