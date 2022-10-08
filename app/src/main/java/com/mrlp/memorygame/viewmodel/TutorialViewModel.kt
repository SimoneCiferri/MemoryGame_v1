package com.mrlp.memorygame.viewmodel

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel

class TutorialViewModel : ViewModel() {

    private val tutorial = "Tutorial"
    private val finish = "Finish"

    fun onTutorialFinished(requireActivity: FragmentActivity) {
        val sharedPref = requireActivity.getSharedPreferences(tutorial, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(finish, true)
        editor.apply()
    }

    fun tutorialDone(requireActivity: FragmentActivity): Boolean{
        val sharedPref = requireActivity.getSharedPreferences(tutorial, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(finish, false)
    }

}