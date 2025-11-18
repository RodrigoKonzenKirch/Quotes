package com.example.quotes.quotes_list.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.common.Resource
import com.example.quotes.quotes_list.domain.models.QuotesScreenState
import com.example.quotes.quotes_list.domain.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesScreenViewModel @Inject constructor(
    private val repository: QuotesRepository
): ViewModel() {

    private val _state = mutableStateOf(QuotesScreenState())
    val state: State<QuotesScreenState> = _state

    init {
        getQuotes()
    }

    private fun getQuotes() {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)

            when(val result = repository.getQuotes()) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        myQuotes = result.data?.quotes ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
            }
        }
    }
}