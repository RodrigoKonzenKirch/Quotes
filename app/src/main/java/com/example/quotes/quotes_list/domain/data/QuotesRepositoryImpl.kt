package com.example.quotes.quotes_list.domain.data

import com.example.quotes.api.QuotesApi
import com.example.quotes.quotes_list.domain.models.Quotes
import com.example.quotes.quotes_list.domain.repository.QuotesRepository
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val api: QuotesApi
):QuotesRepository {

    override suspend fun getQuotes(): Quotes? {
        return api.getQuotes()
    }
}