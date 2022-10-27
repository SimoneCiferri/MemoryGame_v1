package com.mrlp.memorygame.model

data class Player(
    val id: Int,
    val player: String,
    val time: String,
    val data: String,
    val errors: Int,
    val score: Int,
    val achievements: Int
)