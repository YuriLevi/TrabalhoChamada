package com.example.trabalhochamada

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import com.example.trabalhochamada.R.id.lista_aluno
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.list_item_aluno.view.*
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log

//import android.support.test.espresso.matcher.ViewMatchers.isChecked



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



    fun listMaker() {

        Log.d("TRABALHO", "Entrou listMaker")

        textViewTurma.text = "Turma: " + intent.extras.getString(EXTRA_CODIGO)

        //criação da arraylist
        var theListCodAluno = ArrayList<String>()

        //busca os dados da tabela
        var dadosMatricula = db.getListTurmaHasAluno(intent.extras.getString(EXTRA_CODIGO))

        //verifica se dados esta vazio
        if (dadosMatricula.count == 0) {
            Log.d("TRABALHO", "lista vazia")
        } else {
            Log.d("loop codigos", "Entrou while")
            //preenche array somente com os dados da segunda coluna(nome)
            while (dadosMatricula.moveToNext()) {


                var codAluno = dadosMatricula.getString(0)

                Log.d("loop codigos", "codigo: " + codAluno)

                theListCodAluno.add(codAluno)

            }


            //criação da arraylist
            var theList = ArrayList<Aluno>()

            //busca os dados da tabela
            var dadosAlunos = db.getListAlunosPorTurma(theListCodAluno)

            //verifica se dados esta vazio
            if (dadosAlunos.count == 0) {

                Log.d("TRABALHO", "lista vazia")
            } else {


                //preenche array somente com os dados da segunda coluna(nome)
                while (dadosAlunos.moveToNext()) {

                    var alunoAux = Aluno(dadosAlunos.getString(dadosAlunos.getColumnIndex("matricula"))
                            , dadosAlunos.getString(dadosAlunos.getColumnIndex("nome"))
                            , dadosAlunos.getString(dadosAlunos.getColumnIndex("foto_url")),false)

                    theList.add(alunoAux)

                }


                //adiciona o adapter a ListView da tela

                val adapter = AlunoAdapter(this, theList)

                lista_aluno.adapter = adapter



                

            }

        }


    }


}
