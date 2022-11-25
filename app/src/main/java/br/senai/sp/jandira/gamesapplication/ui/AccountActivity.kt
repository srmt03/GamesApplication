package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapplication.dao.games.GamesDao
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding.inflate
import br.senai.sp.jandira.gamesapplication.model.Games
import br.senai.sp.jandira.gamesapplication.repository.GamesRepository

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    lateinit var repository: GamesRepository
    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewBack.setOnClickListener{
            val backView = Intent(this, MainActivity::class.java)
            startActivity(backView)
        }
//        binding.textViewAddGame.setOnClickListener {
//            val openCadastro = Intent(this, AddGamesActivity::class.java)
//            startActivity(openCadastro)
//        }

        //Carregar dados do usuarios
//        loadProfile()

//        Cirar instancia da RecyclerView
//        rvGames = findViewById(R.id.rvGames)
//        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//        Criar uma instancia do adapter
//        adapterGames = GamesAdapter(,this)
//        adapterGames.updateGamesList(GamesDao.getAll())

//        Ligar o adapter a Recycler View
//        rvGames.adapter = adapterGames
    }

//    private fun loadProfile() {
//        TODO("Not yet implemented")
//    }

    //Carregar Recycler view
    override fun onResume() {
        super.onResume()
        carregarRecyclerView()
    }
    private fun carregarRecyclerView() {
        repository = GamesRepository(this)
        val games = repository.getAll()

        adapterGames = GamesAdapter(games, this)
        binding.rvGames.adapter = adapterGames

        //Determinar o layout
        binding.rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}