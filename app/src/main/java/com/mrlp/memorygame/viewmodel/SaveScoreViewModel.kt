package com.mrlp.memorygame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mrlp.memorygame.data.PlayerDatabase
import com.mrlp.memorygame.model.Player
import com.mrlp.memorygame.repository.PlayerRepository
import com.mrlp.memorygame.utils.Values
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat

class SaveScoreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlayerRepository

    init {
        val playerDao = PlayerDatabase.getDatabase(application).playerDao()
        repository = PlayerRepository(playerDao)
    }

    fun getScore(errors: Int, totalTime: Long): Long {
        return Values.SCORE_CONSTANT/((totalTime/3)+(100*errors))
    }

    fun saveScore(playerName: String, score: Int, errors: Int, time: String) {
        val currentDate = getDay()
        val achievements = checkAchievements(score)
        val player = Player(0, playerName, time, currentDate, errors, score, achievements)
        viewModelScope.launch(Dispatchers.IO){
            repository.addScore(player)
        }
    }

    private fun getDay(): String{
        val calendar : java.util.Calendar = java.util.Calendar.getInstance()
        return DateFormat.getDateInstance().format(calendar.time)
    }

    private fun checkAchievements(score: Int): Int {
        if(score < 5500){
            return 0
        }
        if(score in 5501..6999){
            return 1
        }
        if(score in 7001..8499){
            return 2
        }
        if(score in 8501..9999){
            return 3
        }
        else return 4
    }

}