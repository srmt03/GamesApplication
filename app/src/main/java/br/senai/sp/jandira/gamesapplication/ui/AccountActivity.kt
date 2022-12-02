package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapplication.dao.games.GamesDao
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding.inflate
import br.senai.sp.jandira.gamesapplication.model.Games
import br.senai.sp.jandira.gamesapplication.model.Usuario
import br.senai.sp.jandira.gamesapplication.repository.GamesRepository
import br.senai.sp.jandira.gamesapplication.repository.UsuarioRepository

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    lateinit var repository: GamesRepository
    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter
    lateinit var user: Usuario
    lateinit var userRepository: UsuarioRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userRepository = UsuarioRepository(this)
        supportActionBar!!.hide()

        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewBack.setOnClickListener{
            val backView = Intent(this, MainActivity::class.java)
            startActivity(backView)
        }
        binding.textViewAddGame.setOnClickListener {
            val registerGame = Intent(this, AddGamesActivity::class.java)
            startActivity(registerGame)
        }
        //Carregar dados do usuarios -  recuperando eles da outra tela
        val id = intent.getIntExtra("id", 0)
        loadProfile(id)
//        Toast.makeText(this, "$user", Toast.LENGTH_SHORT).show()

//        Cirar instancia da RecyclerView
//        rvGames = findViewById(R.id.rvGames)
//        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//        Criar uma instancia do adapter
//        adapterGames = GamesAdapter(,this)
//        adapterGames.updateGamesList(GamesDao.getAll())

//        Ligar o adapter a Recycler View
//        rvGames.adapter = adapterGames
    }

    private fun loadProfile(id: Int) {
        user = userRepository.getUsuarioById(id)
        binding.textViewUsername.text = user.nome
        binding.textViewUserEmail.text = user.email
//        binding.imageViewPerfil
        binding.textViewPlaying.text = "0"
        binding.textViewGamesFinished.text = "0"
        binding.textViewNivel.text = user.nivel.toString()
        binding.textViewAge.text = user.idade
    }

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