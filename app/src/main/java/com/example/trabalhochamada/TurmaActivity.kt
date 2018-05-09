package com.example.trabalhochamada

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.trabalhochamada.ListViewActivity.Companion.EXTRA_CODIGO
import kotlinx.android.synthetic.main.activity_turma.*

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

        //criação da arraylist
        var theList = ArrayList<Turma>()

        //busca os dados da tabela
        var dados = db.getList2(intent.extras.getString(EXTRA_CODIGOP))

        //verifica se dados esta vazio
        if(dados.count ==0){

            Log.d("TRABALHO", "lista vazia")
        }else{



            //preenche array somente com os dados da segunda coluna(nome)
            while(dados.moveToNext()){

                var turmaAux = Turma(dados.getString(dados.getColumnIndex("codigo"))
                        ,dados.getString(dados.getColumnIndex("hora"))
                        ,dados.getInt(3)
                        ,dados.getString(dados.getColumnIndex("disciplina")))

                Log.d("turmaZ", "turma: " + dados.getInt(1))

                theList.add(turmaAux)

            }



            val adapter = TurmaAdapter(this,theList)

            lista_turma.adapter = adapter



            val context = this

            lista_turma.setOnItemClickListener { _, _, position, _ ->
                // 1
                val selectedTurma = theList[position]

                // 2
                val detailIntent = ListViewActivity.newIntent(context, selectedTurma)

                // 3
                startActivity(detailIntent)
            }


        }



    }
}
