package com.mrlp.memorygame.viewmodel

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.mrlp.memorygame.utils.Values

class SplashViewModel : ViewModel() {

    fun tutorialDone(requireActivity: FragmentActivity): Boolean{
        val sharedPref = requireActivity.getSharedPreferences(Values.TUTORIAL, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(Values.FINISH, false)
    }
}