package com.example.quotes.quotes_list.domain.data

import com.example.quotes.api.QuotesApi
import com.example.quotes.common.Resource
import com.example.quotes.quotes_list.domain.models.Quotes
import com.example.quotes.quotes_list.domain.repository.QuotesRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val api: QuotesApi
) : QuotesRepository {

    override suspend fun getQuotes(): Resource<Quotes> {
        return try {
            val response = api.getQuotes()
            if (response.isSuccessful) {
                val result = response.body()
                if (result != null) {
                    Resource.Success(result)
                } else {
                    Resource.Error("An unexpected error occurred")
                }
            } else {
                Resource.Error(response.message() ?: "An unexpected error occurred")
            }
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }
}