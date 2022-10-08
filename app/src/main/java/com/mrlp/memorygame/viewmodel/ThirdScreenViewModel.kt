package com.mrlp.memorygame.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel

class ThirdScreenViewModel : ViewModel() {

    private val mTutorialViewModel = TutorialViewModel()

    fun onTutorialFinished(requireActivity: FragmentActivity) {
        mTutorialViewModel.onTutorialFinished(requireActivity)
    }
}