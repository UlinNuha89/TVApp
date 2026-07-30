package com.lynn.tvapp.presentation.home

import com.lynn.tvapp.data.model.Show

data class HomeUiState(
    val isLoading: Boolean = false,
    val shows: List<Show> = emptyList(),
    val error: String? = null
)
