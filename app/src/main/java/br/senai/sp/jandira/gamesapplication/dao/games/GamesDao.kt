package br.senai.sp.jandira.gamesapplication.dao.games

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.model.Games

@Dao
interface GamesDao {
    //CRUID GAMES
    @Insert
    fun save (games: Games): Long
    @Update
    fun update (games: Games): Int
    @Delete
    fun delete (games: Games): Int
    @Query("SELECT * FROM tbl_games ORDER BY titulo ASC")
    fun getAll(): List<Games>
    @Query("SELECT * FROM tbl_games WHERE id = :id")
    fun getGameById(id: Int): Games
}