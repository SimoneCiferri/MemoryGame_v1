package com.mrlp.memorygame.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import com.mrlp.memorygame.model.Values

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class PlayerDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    companion object{
        private var INSTANCE: PlayerDatabase? = null

        fun getDatabase(context: Context): PlayerDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlayerDatabase::class.java,
                    Values.DATABASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}