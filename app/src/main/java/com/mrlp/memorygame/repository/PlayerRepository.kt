package com.mrlp.memorygame.repository

import androidx.lifecycle.LiveData
import com.mrlp.memorygame.data.Player
import com.mrlp.memorygame.data.PlayerDao

class PlayerRepository(private val playerDao: PlayerDao) {

    val readAllData: LiveData<List<Player>> = playerDao.readAllData()

    suspend fun addPlayer(player: Player){
        playerDao.addPlayer(player)
    }

    fun getCount():Int{
        return playerDao.getCount()
    }


}