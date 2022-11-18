package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.dao.console.ConsoleDb
import br.senai.sp.jandira.gamesapplication.dao.usuario.UsuarioDb
import br.senai.sp.jandira.gamesapplication.model.Console
import br.senai.sp.jandira.gamesapplication.model.Games
import br.senai.sp.jandira.gamesapplication.model.Usuario

class UsuarioRepository(context: Context) {
    private val db = UsuarioDb.getDataBase(context).usuarioDao()

    fun save (usuario: Usuario): Long {
        return db.save(usuario)
    }
    fun update (usuario: Usuario): Int {
        return db.update(usuario)
    }
    fun delete (usuario: Usuario): Int {
        return db.delete(usuario)
    }
    fun getAll (): List<Usuario> {
        return db.getAll()
    }
    fun getUsuarioById (id: Int): Usuario {
     return db.getUsuarioById(id)
    }
}