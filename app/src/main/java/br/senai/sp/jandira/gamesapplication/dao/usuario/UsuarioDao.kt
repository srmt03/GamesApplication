package br.senai.sp.jandira.gamesapplication.dao.usuario

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.model.Console
import br.senai.sp.jandira.gamesapplication.model.Usuario

@Dao
interface UsuarioDao {
    //CRUID USUARIO
    @Insert
    fun save(usuario: Usuario): Long
    @Update
    fun update (usuario: Usuario): Int
    @Delete
    fun delete (usuario: Usuario): Int
    @Query("SELECT * FROM tbl_usuario ORDER BY nome ASC")
    fun getAll(): List<Usuario>
    @Query("SELECT * FROM tbl_usuario WHERE id = :id")
    fun getUsuarioById(id: Int): Usuario
    @Query("SELECT * FROM tbl_usuario WHERE email = :email")
    fun getUsuarioByEmail(email: String): Usuario
}