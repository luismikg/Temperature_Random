package com.luis.hsbctest.ui.temperature.presentation.temperature.states

sealed class LoadingState {
    object Loading : LoadingState()
    data class Error(val error: String) : LoadingState()
    data class Success(
        val location: String = "",
        val temperature: String = ""
    ) : LoadingState()
}
