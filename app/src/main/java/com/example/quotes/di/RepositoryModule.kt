package com.example.quotes.di

import com.example.quotes.api.QuotesApi
import com.example.quotes.quotes_list.domain.data.QuotesRepositoryImpl
import com.example.quotes.quotes_list.domain.repository.QuotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryInstance(api: QuotesApi) : QuotesRepository {
        return QuotesRepositoryImpl(api)
    }
}