package br.senai.sp.jandira.gamesapplication.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_games")
class Games {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    //var foto:Bitmap? = null
    var foto = ""
    var titulo = ""
    var descricao = ""
    var estudio = ""
    var anoLancamento = 0

    //var finalizado = true
    var finalizado = 0
}
