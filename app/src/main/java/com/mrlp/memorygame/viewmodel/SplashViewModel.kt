package com.mrlp.memorygame.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    private val mTutorialViewModel = TutorialViewModel()

    fun tutorialDone(requireActivity: FragmentActivity): Boolean{
        return mTutorialViewModel.tutorialDone(requireActivity)
    }
}