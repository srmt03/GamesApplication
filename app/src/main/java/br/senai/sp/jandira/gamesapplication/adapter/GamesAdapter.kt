package br.senai.sp.jandira.gamesapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.model.Games
import org.w3c.dom.Text

class GamesAdapter(var gamesList: List<Games>, var context: Context):RecyclerView.Adapter<GamesAdapter.GamesHolder>() {
    fun updateGamesList(newGameList: List<Games>) {
        this.gamesList = newGameList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
        return GamesHolder(view)
    }

    override fun onBindViewHolder(holder: GamesHolder, position: Int) {
        val game = gamesList[position]

        holder.textViewTitulo.text = game.titulo
        holder.textViewEstudio.text = game.estudio
        holder.textViewDescricao.text = game.descricao
        //holder.imageViewHolder. = game.foto
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }
    class GamesHolder(view: View):RecyclerView.ViewHolder(view) {
        val textViewTitulo: TextView = view.findViewById(R.id.textViewNome)
        val textViewEstudio: TextView = view.findViewById(R.id.textViewEstudio)
        val textViewDescricao: TextView = view.findViewById(R.id.textViewDescricao)
        val imageViewHolder: ImageView = view.findViewById(R.id.imageHolder)
    }
}