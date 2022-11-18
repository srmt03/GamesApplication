package br.senai.sp.jandira.gamesapplication.dao.games

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapplication.model.Games

@Database(entities = [Games::class], version = 1)
abstract class GamesDb: RoomDatabase() {
    abstract fun gamesDao(): GamesDao
    companion object {
        private lateinit var instance: GamesDb
        fun getDataBase(context: Context): GamesDb{
            if (!::instance.isInitialized){
                instance = Room.databaseBuilder(context, GamesDb::class.java, "db_games").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}