package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAddGamesBinding

class AddGamesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddGamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        binding = ActivityAddGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveGame.setOnClickListener {
            val openAccount = Intent(this, AccountActivity::class.java)
            startActivity(openAccount)
        }
    }
}