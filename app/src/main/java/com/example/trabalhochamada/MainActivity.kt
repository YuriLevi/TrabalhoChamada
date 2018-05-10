package com.example.trabalhochamada


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //Login Pre Inseridos

    //professor1
    //Login jorel
    //Senha 12345

    //professor2
    //Login silvio
    //Senha 54321



    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun fazerLogin(view: View){

        Log.d("TRABALHO", "entrou fazerlogin")


        if(login.text.toString().isBlank() || senha.text.toString().isBlank() )
            Toast.makeText(this,"Preencha os campos", Toast.LENGTH_LONG).show()
        else {


            val vProfessor = Professor(login.text.toString(), senha.text.toString())


            var validaUsuario = db.verificaLogin(vProfessor)


            if (validaUsuario.get("check") == true) {

                Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()


                val novaTela = TurmaActivity.newIntent(this,validaUsuario.get("id").toString() )

                startActivity(novaTela)


            } else {

                Toast.makeText(this, "Dados Invalidos", Toast.LENGTH_LONG).show()
            }

        }

    }


}
