package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.dao.console.ConsoleDb
import br.senai.sp.jandira.gamesapplication.dao.games.GamesDb
import br.senai.sp.jandira.gamesapplication.model.Console
import br.senai.sp.jandira.gamesapplication.model.Games

class GamesRepository(context: Context) {
    private val db = GamesDb.getDataBase(context).gamesDao()

    fun save (games: Games): Long {
        return db.save(games)
    }
    fun update (games: Games): Int {
        return db.update(games)
    }
    fun delete (games: Games): Int {
        return db.delete(games)
    }
    fun getAll (): List<Games> {
        return db.getAll()
    }
    fun getGameById (id: Int): Games {
        return db.getGameById(id)
    }

}