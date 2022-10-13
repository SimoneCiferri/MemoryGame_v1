package com.mrlp.memorygame.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.mrlp.memorygame.R

class MainActivityViewModel : ViewModel() {

    private lateinit var mp: MediaPlayer
    private var mpState = false

    fun setOST(context: Context){
        mp = MediaPlayer.create(context, R.raw.memorygameost)
        mp.isLooping = true
        mp.start()
        mpState = true
    }

    fun mpPause() {
        mp.pause()
    }

    fun mpResume() {
        if(mpState){
            mp.start()
        }
    }

}