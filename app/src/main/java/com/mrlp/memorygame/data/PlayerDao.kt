package com.mrlp.memorygame.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlayer(player: Player)

    @Query("SELECT * FROM player_table ORDER BY score DESC")
    fun readAllData(): LiveData<List<Player>>

    @Query("SELECT COUNT(*) FROM player_table")
    fun getCount(): Int


}