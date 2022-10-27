package com.mrlp.memorygame.repository

import androidx.lifecycle.LiveData
import com.mrlp.memorygame.data.Player
import com.mrlp.memorygame.data.PlayerDao

class PlayerRepository(private val playerDao: PlayerDao) {

    val readAllData: LiveData<List<Player>> = playerDao.readAllData()

    suspend fun addScore(player: com.mrlp.memorygame.model.Player) {
        val newPlayer = Player(player.id, player.player, player.time, player.data, player.errors, player.score, player.achievements)
        playerDao.addPlayer(newPlayer)
    }

    fun getCount():Int{
        return playerDao.getCount()
    }

}