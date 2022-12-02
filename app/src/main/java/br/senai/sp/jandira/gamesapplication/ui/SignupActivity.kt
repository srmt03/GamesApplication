package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.ActivitySignupBinding
import br.senai.sp.jandira.gamesapplication.model.NiveisEnum
import br.senai.sp.jandira.gamesapplication.model.Usuario
import br.senai.sp.jandira.gamesapplication.repository.UsuarioRepository

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    lateinit var usuarioRepository: UsuarioRepository
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textViewSavePerfil.setOnClickListener{
            if (save()){
                val openAccountActivity = Intent(this, MainActivity::class.java)
                startActivity(openAccountActivity)
            }
        }
        binding.sliderLevel.addOnChangeListener { slider, value, usuario ->
            binding.textViewLevel.text = gameLevel(value.toInt())!!.nivel
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_save) {
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    //Atribuir valores ao Level
    private fun gameLevel(value: Int): NiveisEnum {
        if (value == 1){
            return NiveisEnum.INICIANTE
        }
        if (value == 2) {
            return NiveisEnum.BASICO
        }
        if (value == 3) {
            return NiveisEnum.CASUAL
        }
        return NiveisEnum.AVANCADO
    }

    //Salvar o novo perfil
    private fun save(): Boolean {
        if (validate()){
            usuario = Usuario()
            usuario.email = binding.editEmail.text.toString()
            usuario.senha = binding.editPass.text.toString()
            usuario.nome = binding.editName.text.toString()
            usuario.cidade = binding.editCity.text.toString()
            usuario.idade = binding.editDate.text.toString()

            //Instancia do repositorio
            usuarioRepository = UsuarioRepository(this)
            val id = usuarioRepository.save(usuario)
            Toast.makeText(this, "ID: $id", Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }

    //Validar os campos de cadastro
    private fun validate(): Boolean {
        if(binding.editEmail.text.isEmpty()){
            binding.editEmail.error = "Email is required"
            return false
        }
        if (binding.editPass.text.isEmpty()){
            binding.editPass.error = "Password is required"
            return false
        }
        if (binding.editName.text.isEmpty()){
            binding.editName.error = "Name is required"
            return false
        }
        if (binding.editCity.text.isEmpty()){
            binding.editCity.error = "City is required"
            return false
        }
        if (binding.editDate.text.isEmpty()){
            binding.editDate.error = "Birthdate is required"
        }
        return true
    }
}