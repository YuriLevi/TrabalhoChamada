package com.example.trabalhochamada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //db.cargaDados()

    }

    fun fazerLogin(view: View){

        Log.d("TRABALHO", "entrou fazerlogin")

        //verifica campo vazio
        if(login.text.toString().isBlank() || senha.text.toString().isBlank() )
            Toast.makeText(this,"Preencha os campos", Toast.LENGTH_LONG).show()
        else {

            //criação de objeto do tipo Professor construido com os parametros recebidos dos campos
            val vProfessor = Professor(login.text.toString(), senha.text.toString())

            // recupera um boolean da função "verificaLogin" que recebe o objeto Professor
            var validaUsuario = db.verificaLogin(vProfessor)

            //Caso o login e senha esteja correto, mostra um toast e chama a nova tela
            if (validaUsuario == true) {

                Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()

                val novaTela = Intent(this, TurmaActivity::class.java)

                startActivity(novaTela)

            } else {

                Toast.makeText(this, "Dados Invalidos", Toast.LENGTH_LONG).show()
            }

        }

    }


}
