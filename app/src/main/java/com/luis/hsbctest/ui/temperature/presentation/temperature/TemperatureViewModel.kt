package com.luis.hsbctest.ui.temperature.presentation.temperature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luis.hsbctest.ui.temperature.domain.useCases.GetRandomTemperatureUseCase
import com.luis.hsbctest.ui.temperature.presentation.temperature.states.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TemperatureViewModel @Inject constructor(
    private val getRandomTemperatureUseCase: GetRandomTemperatureUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<LoadingState>(
        LoadingState.Success()
    )
    val state = _state.asStateFlow()

    fun onSearchTemperature() {

        viewModelScope.launch {
            _state.value = LoadingState.Loading

            val result = withContext(Dispatchers.IO) { getRandomTemperatureUseCase() }
            if (result != null) {
                _state.value = LoadingState.Success(
                    location = result.place,
                    temperature = "${result.value} ${result.unit}"
                )
            } else {
                _state.value = LoadingState.Error("Error")
            }
        }
    }
}