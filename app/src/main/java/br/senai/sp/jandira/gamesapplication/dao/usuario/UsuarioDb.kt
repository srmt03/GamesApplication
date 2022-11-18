package br.senai.sp.jandira.gamesapplication.dao.usuario

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapplication.dao.console.ConsoleDao
import br.senai.sp.jandira.gamesapplication.dao.console.ConsoleDb
import br.senai.sp.jandira.gamesapplication.model.Usuario

//Quando setamos essa classe como database precisamos declarar todas as entidades do seu banco
@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDb: RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    companion object {
        private lateinit var instance: UsuarioDb
        fun getDataBase(context: Context): UsuarioDb {
            if (!::instance.isInitialized){
                instance = Room.databaseBuilder(context, UsuarioDb::class.java, "db_usuario").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}

