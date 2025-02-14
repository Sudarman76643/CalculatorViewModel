package com.example.calculatorviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorviewmodel.modelData.CalculationResult

class MainViewModel : ViewModel() {
    var result = 0

    private val _results = MutableLiveData<List<CalculationResult>>(mutableListOf())
    val results: LiveData<List<CalculationResult>> = _results

    fun calculate(width: String, height: String, length: String) {
        val w = width.toIntOrNull() ?: return
        val h = height.toIntOrNull() ?: return
        val l = length.toIntOrNull() ?: return

        val newResult = CalculationResult(w, h, l, w * h * l)

        val updatedList = _results.value?.toMutableList() ?: mutableListOf()
        updatedList.add(newResult)

        _results.postValue(updatedList)
    }
}
