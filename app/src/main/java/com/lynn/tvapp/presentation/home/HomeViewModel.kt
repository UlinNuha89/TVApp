package com.lynn.tvapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynn.tvapp.data.model.Show
import com.lynn.tvapp.data.repository.ShowRepository
import com.lynn.tvapp.utils.proceedWhen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ShowRepository) : ViewModel() {
    val dummyList = listOf(
        Show(
            id = 1,
            url = "",
            name = "Breaking Bad",
            image = "https://static.tvmaze.com/uploads/images/original_untouched/0/2400.jpg",
            rating = "9.4"
        ),
        Show(
            id = 2,
            url = "",
            name = "Game of Thrones",
            image = "https://static.tvmaze.com/uploads/images/original_untouched/190/476117.jpg",
            rating = "8.9"
        )
    )
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getShows()
    }

    private fun getShows() {
        viewModelScope.launch {
            repository.getShow().collect { result ->
                result.proceedWhen(
                    doOnLoading = {
                        _uiState.update {
                            it.copy(
                                isLoading = true,
                                error = null
                            )
                        }
                    },
                    doOnSuccess = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                shows = result.payload ?: emptyList()
                            )
                        }
                    },

                    doOnEmpty = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                shows = emptyList()
                            )
                        }
                    },

                    doOnError = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = result.exception?.message
                            )
                        }
                    }
                )
            }
        }
    }
}