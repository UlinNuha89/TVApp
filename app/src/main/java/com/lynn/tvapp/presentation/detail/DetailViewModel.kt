package com.lynn.tvapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynn.tvapp.data.repository.DetailRepository
import com.lynn.tvapp.utils.proceedWhen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: DetailRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    fun getDetail(id: Int) {
        viewModelScope.launch {
            repository.getDetail(id).collect { result ->
                result.proceedWhen(
                    doOnLoading = {
                        _uiState.update {
                            it.copy(isLoading = true)
                        }
                    },
                    doOnSuccess = {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                detail = result.payload
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