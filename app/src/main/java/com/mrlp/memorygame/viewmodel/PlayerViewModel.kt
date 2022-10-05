package com.mrlp.memorygame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mrlp.memorygame.data.Player
import com.mrlp.memorygame.data.PlayerDatabase
import com.mrlp.memorygame.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Player>>
    private val repository: PlayerRepository

    init{
        val playerDao = PlayerDatabase.getDatabase(application).playerDao()
        repository = PlayerRepository(playerDao)
        readAllData = repository.readAllData
    }

    fun addPlayer(player: Player){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPlayer(player)
        }
    }

}