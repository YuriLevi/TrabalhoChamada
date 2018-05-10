package com.example.trabalhochamada

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_turma.*
import java.util.*

class TurmaActivity : AppCompatActivity() {

    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turma)

        listMaker()

    }


    companion object {
        const val EXTRA_CODIGOP = "codigoP"


        fun newIntent(context: Context, id: String): Intent {
            val detailIntent = Intent(context, TurmaActivity::class.java)

            detailIntent.putExtra(EXTRA_CODIGOP, id)


            return detailIntent
        }


    }



    fun listMaker(){


        Log.d("TRABALHO", "Entrou listMakerTurma")


        var theList = ArrayList<Turma>()


        var dados = db.getListTurma(intent.extras.getString(EXTRA_CODIGOP))


        if(dados.count ==0){

            Log.d("TRABALHO", "lista vazia")
        }else{



            while(dados.moveToNext()){

                var turmaAux = Turma(dados.getString(dados.getColumnIndex("codigo"))
                        ,dados.getString(dados.getColumnIndex("hora"))
                        ,dados.getInt(2)
                        ,dados.getInt(4)
                        ,dados.getString(dados.getColumnIndex("disciplina")))

                Log.d("turmaZ", "turma: " + dados.getInt(4))

                theList.add(turmaAux)

            }


            val adapter = TurmaAdapter(this,theList)

            lista_turma.adapter = adapter


            val context = this

            lista_turma.setOnItemClickListener { _, _, position, _ ->

                val selectedTurma = theList[position]

                val today = Calendar.getInstance()



                Log.d("zzzdasd", "dia da turma:" +selectedTurma.dia+ " dia da semana " +  today.get(Calendar.DAY_OF_WEEK) )

                if(selectedTurma.dia == today.get(Calendar.DAY_OF_WEEK)){

                    val detailIntent = ListViewActivity.newIntent(context, selectedTurma, intent.extras.getString(EXTRA_CODIGOP) )

                    startActivity(detailIntent)

                }else{


                    Toast.makeText(this, "Data Incorreta para abrir a turma", Toast.LENGTH_LONG).show()
                }



            }


        }



    }
}
