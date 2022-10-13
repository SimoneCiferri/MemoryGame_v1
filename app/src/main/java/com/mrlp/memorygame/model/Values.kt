package com.mrlp.memorygame.model

class Values {

    companion object{
        const val SPLASH_FRAGMENT_DELAY: Long = 3000
        const val ALPHA_BUTTON_ENABLED: Float = 1f
        const val ALPHA_BUTTON_DISABLED: Float = 0.5f
        const val ALPHA_BUTTON_MATCHED: Float = 0.3f
        const val ZOOM_ANIM_DURATION: Long = 1000
        const val FLIP_ANIM_DURATION: Long = 350
        const val CHECK_ERROR: Int = 0
        const val FIRST_CARD: Int = 1
        const val CARD_MATCHED: Int = 2
        const val CARD_NOT_MATCHED: Int = 3

        const val DATABASE_NAME = "player_database"
    }
}