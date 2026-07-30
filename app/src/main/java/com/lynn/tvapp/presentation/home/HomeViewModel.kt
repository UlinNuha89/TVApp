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
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getShows()
    }

    fun retry() {
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
                                shows = emptyList(),
                                error = null
                            )
                        }
                    },
                    doOnSuccess = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                shows = result.payload ?: emptyList(),
                                error = null,
                            )
                        }
                    },
                    doOnEmpty = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                shows = emptyList(),
                                error = "Empty"
                            )
                        }
                    },
                    doOnError = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                shows = emptyList(),
                                error = result.exception?.message
                            )
                        }
                    }
                )
            }
        }
    }
}