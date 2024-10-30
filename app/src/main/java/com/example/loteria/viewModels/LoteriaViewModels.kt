package com.example.loteria.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoteriaViewModels : ViewModel() {
    private val _lotoNumbers = mutableStateOf<List<Int>>(emptyList())
    val lotoNumbers: State<List<Int>> = _lotoNumbers

    private val _isGenerating = mutableStateOf(false)
    val isGenerating: State<Boolean> = _isGenerating

    fun generateLotoNumbers() {
        viewModelScope.launch {
            _isGenerating.value = true
            _lotoNumbers.value = emptyList()  // Reset numbers
            val generatedNumbers = (1..60).shuffled().take(6).sorted()

            for (number in generatedNumbers) {
                _lotoNumbers.value = _lotoNumbers.value + number
                delay(2000)  // Espera 2 segundos entre cada número
            }

            _isGenerating.value = false
        }
    }
}
