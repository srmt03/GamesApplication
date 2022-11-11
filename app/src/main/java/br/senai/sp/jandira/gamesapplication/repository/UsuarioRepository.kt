package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.dao.console.ConsoleDb
import br.senai.sp.jandira.gamesapplication.model.Console

class UsuarioRepository(context: Context) {
    private val db = ConsoleDb.getDatabase(context).consoleDao()

    fun save (console: Console): Long {
        return db.save(console)
    }
    fun update (console: Console): Int {
        return db.update(console)
    }
    fun delete (console: Console): Int {
        return db.delete(console)
    }
    fun getAll (): List<Console> {
        return db.getAll()
    }
    fun getConsoleById (id: Int): Console {
        return db.getConsoleById(id)
    }
}