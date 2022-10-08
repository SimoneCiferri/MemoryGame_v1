package com.mrlp.memorygame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _error = MutableLiveData<Int>().apply {
        value = 0
    }

    var error: LiveData<Int> = _error

    fun increaseErrors(){
        _error.value = error.value?.plus(1)
    }

    private fun resetErrors(){
        _error.value = 0
    }

    fun newGame() {
        resetErrors()
    }
}