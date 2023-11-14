package com.example.uts2.presentation.viewmodels


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class InputViewModel : ViewModel() {
    var bodyMass by mutableStateOf("")
        private set

    var bodyHeight by mutableStateOf("")
        private set

    var category by mutableStateOf("")
        private set

    private var bmi by mutableStateOf(0.0)

    fun updateBodyMass(input : String) {
        bodyMass = input
    }

    fun updateBodyHeight(input : String) {
        bodyHeight = input
    }

    fun updateCategory() {
        when {
            bmi < 18.5 -> category = "Underweight"
            bmi in 18.5..25.0 -> category = "Normal"
            bmi > 25 -> category = "Overweight"
        }
    }

    fun calculateBMI(): Double {
        val bmi =  bodyMass.toDouble() / (bodyHeight.toDouble() * bodyHeight.toDouble())
        this.bmi = bmi

        return bmi
    }
}