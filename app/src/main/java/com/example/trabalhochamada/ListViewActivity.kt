package com.example.trabalhochamada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listMaker()
    }

    fun listMaker(){

        Log.d("TRABALHO", "Entrou listMaker")

        //criação da arraylist
        var theList = ArrayList<String>()

        //busca os dados da tabela
        var dados = db.getList()

        //verifica se dados esta vazio
        if(dados.count ==0){

            Log.d("TRABALHO", "lista vazia")
        }else{

            //preenche array somente com os dados da segunda coluna(nome)
            while(dados.moveToNext()){
                theList.add(dados.getString(1))

                //cria um adapter e o preenche utilizando os dados que estão na array
                var listAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,theList)

                //adiciona o adapter a ListView da tela
                lista.adapter = listAdapter

            }

        }



    }



}
