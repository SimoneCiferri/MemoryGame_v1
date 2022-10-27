package com.mrlp.memorygame.viewmodel

import android.renderscript.Sampler.Value
import androidx.lifecycle.ViewModel
import com.mrlp.memorygame.utils.Values

class SaveScoreViewModel : ViewModel() {

    fun getScore(errors: Int, totalTime: Long): Long {
        return Values.SCORE_CONSTANT/((totalTime/3)+(100*errors))
    }

}