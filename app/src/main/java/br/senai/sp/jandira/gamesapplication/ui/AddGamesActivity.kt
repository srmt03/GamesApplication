package br.senai.sp.jandira.gamesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding

class AddGamesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}