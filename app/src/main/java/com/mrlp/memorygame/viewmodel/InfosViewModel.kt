package com.mrlp.memorygame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is infos Fragment"
    }
    val text: LiveData<String> = _text
}