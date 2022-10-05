package com.mrlp.memorygame.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val player: String,
    val time: String,
    val Data: String,
    val errors: Int,
    val score: Int,
    val achievements: Int
)