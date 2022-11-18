package br.senai.sp.jandira.gamesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding.inflate
import br.senai.sp.jandira.gamesapplication.model.Games
import br.senai.sp.jandira.gamesapplication.repository.GamesRepository

class AccountActivity : AppCompatActivity() {
    lateinit var binding: AccountActivity
    lateinit var repository: GamesRepository
    lateinit var adapter: GamesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        supportActionBar!!.hide()

        binding = AccountActivity.inflate(layoutInflater)
        setContentView(binding.root)
    }
    //Carregar Recycler view
    override fun onResume() {
        super.onResume()
        carregarRecyclerView()
    }
    private fun carregarRecyclerView() {
        repository = GamesRepository(this)
        val games = repository.getAll()

        adapter = GamesAdapter(games, this)
        binding.rvGames.adapter = adapter

        //Determinar o layout
        binding.rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}