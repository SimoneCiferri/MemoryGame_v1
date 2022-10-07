package com.mrlp.memorygame.viewmodel

import androidx.lifecycle.ViewModel

class ThirdScreenViewModel : ViewModel() {

    private val mTutorialViewModel = TutorialViewModel()

    fun onTutorialFinished() {
        mTutorialViewModel.onTutorialFinished()
    }
}