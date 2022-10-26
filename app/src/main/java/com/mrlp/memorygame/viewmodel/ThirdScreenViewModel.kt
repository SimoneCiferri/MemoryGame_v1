package com.mrlp.memorygame.viewmodel

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.mrlp.memorygame.utils.Values

class ThirdScreenViewModel : ViewModel() {

    fun onTutorialFinished(requireActivity: FragmentActivity) {
        val sharedPref = requireActivity.getSharedPreferences(Values.TUTORIAL, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(Values.FINISH, true)
        editor.apply()
    }
}