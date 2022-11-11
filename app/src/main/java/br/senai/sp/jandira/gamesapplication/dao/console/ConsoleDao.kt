package br.senai.sp.jandira.gamesapplication.dao.console

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.model.Console

@Dao
interface ConsoleDao {
    //CRUID CONSOLE
    @Insert
    fun save(console: Console): Long
    @Update
    fun update (console: Console): Int
    @Delete
    fun delete (console: Console): Int
    @Query("SELECT * FROM tbl_console ORDER BY nome ASC")
    fun getAll(): List<Console>
    @Query("SELECT * FROM tbl_console WHERE id = :id")
    fun getConsoleById(id: Int): Console
}