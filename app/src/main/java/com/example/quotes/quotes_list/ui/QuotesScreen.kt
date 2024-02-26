package com.example.quotes.quotes_list.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuotesScreen(
    viewModel: QuotesScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state
    viewModel.getQuotes()
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)){
        items(state.value.myQuotes) {quote ->
            QuoteComposable(quote = quote)
        }
    }
}