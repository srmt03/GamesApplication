package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.dao.usuario.UsuarioDb.Companion.getDataBase
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding
import br.senai.sp.jandira.gamesapplication.model.Usuario
import br.senai.sp.jandira.gamesapplication.repository.UsuarioRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userRepository: UsuarioRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewCreateAccount.setOnClickListener{
            val openSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(openSignupActivity)
        }
        binding.buttonLogin.setOnClickListener {
            login()
        }
    }
    private fun login(): Boolean {
        if (validar()){
            val emailInput = binding.editTextEmail.text.toString()
            userRepository = UsuarioRepository(this)
            val user = userRepository.getUsuarioByEmail(emailInput)

            //Verificar se os dados de autenticacao estão corretos
            if (user === null) {
                Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                return false
            } else if (user.senha != binding.editTextPassword.text.toString()) {
                Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                return false
            } else {
                val openAccountActivity = Intent(this, AccountActivity::class.java)
                openAccountActivity.putExtra("id", user.id)
                startActivity(openAccountActivity)
            }
            return true
        }
        return false
    }
    private fun validar(): Boolean {
        if (binding.editTextEmail.text.isEmpty()){
            binding.editTextEmail.error = "E-mail is required"
            return false
        }
        if (binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "Password is required"
            return false
        }
        return true
    }
}