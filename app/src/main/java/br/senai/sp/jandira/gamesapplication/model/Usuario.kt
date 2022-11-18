package br.senai.sp.jandira.gamesapplication.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.time.LocalDate

@Entity(tableName = "tbl_usuario")
class Usuario {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    //var foto:Bitmap? = null
    var foto = ""
    var email = ""
    var senha = ""
    var nome = ""
    var cidade = ""

    @ColumnInfo(name = "data_nascimento")
    //var dataNascimento:LocalDate? = null
    var dataNascimento = ""

    var nivel = NiveisEnum.INICIANTE

    //var console: Console? = null
    var console = 0

    var sexo = 'I'
}