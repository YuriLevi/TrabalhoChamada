package com.example.trabalhochamada

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.trabalhochamada.R.id.lista
import com.example.trabalhochamada.R.id.lista_aluno
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {




    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        listMaker()
    }

    companion object {
        const val EXTRA_CODIGO = "codigo"


        fun newIntent(context: Context, turma: Turma): Intent {
            val detailIntent = Intent(context, ListViewActivity::class.java)

            detailIntent.putExtra(EXTRA_CODIGO, turma.codigo.toString())


            return detailIntent
        }


    }





    fun listMaker(){

        Log.d("TRABALHO", "Entrou listMaker")

        textViewTurma.text =  "turma: " +intent.extras.getString(EXTRA_CODIGO)

        //criação da arraylist
        var theList = ArrayList<Aluno>()

        //busca os dados da tabela
        var dados = db.getList()

        //verifica se dados esta vazio
        if(dados.count ==0){

            Log.d("TRABALHO", "lista vazia")
        }else{



            //preenche array somente com os dados da segunda coluna(nome)
            while(dados.moveToNext()){

                var alunoAux = Aluno(dados.getString(dados.getColumnIndex("matricula"))
                                    ,dados.getString(dados.getColumnIndex("nome"))
                                    ,dados.getString(dados.getColumnIndex("foto_url")))

                theList.add(alunoAux)

            }


            //adiciona o adapter a ListView da tela

            Log.d("lista", "matricula1: " + theList.get(0).matricula)
            Log.d("lista", "matricula2: " + theList.get(1).matricula)



            val adapter = AlunoAdapter(this,theList)

            lista_aluno.adapter = adapter

        }




    }



}
