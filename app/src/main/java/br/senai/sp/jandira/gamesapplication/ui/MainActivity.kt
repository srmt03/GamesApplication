package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.dao.usuario.UsuarioDb.Companion.getDataBase
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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
    private fun login() {
        if (validar()){
            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()

            //Abrir o (SharedPreferences) - BANCO DE DADOS!
            val dados = getDataBase(this)

            val emailBD = dados.usuarioDao()
            val passBD = dados.usuarioDao()

            //val emailBD = dados.getString("email", "E-mail não encontrado")
            //val passBD = dados.getString("password", "")

            //Verificar se os dados de autenticacao estão corretos
//            if (email == emailBD && pass == passBD){
//                val openAccount = Intent(this, AccountActivity::class.java)
//                startActivity(openAccount)
//            } else {
//                Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
//            }
        }
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