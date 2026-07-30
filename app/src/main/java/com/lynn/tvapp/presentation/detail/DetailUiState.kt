package com.lynn.tvapp.presentation.detail

import com.lynn.tvapp.data.model.Detail

data class DetailUiState(
    val isLoading: Boolean = false,
    val detail: Detail? = null,
    val error: String? = null
)