package com.example.trabalhochamada


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import java.text.SimpleDateFormat
import java.util.*



class ListViewActivity : AppCompatActivity() {


    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        listMaker()
    }

    companion object {
        const val EXTRA_CODIGOT = "codigo"
        const val EXTRA_CODIGOP = "codigop"



        fun newIntent(context: Context, turma: Turma, codigoP : String): Intent {
            val detailIntent = Intent(context, ListViewActivity::class.java)

            detailIntent.putExtra(EXTRA_CODIGOT, turma.codigo.toString())
            detailIntent.putExtra(EXTRA_CODIGOP, codigoP)

            return detailIntent
        }

    }


    fun listMaker() {

        Log.d("TRABALHO", "Entrou listMaker")

        textViewTurma.text = "Turma: " + intent.extras.getString(EXTRA_CODIGOT)


        var theListCodAluno = ArrayList<String>()


        var dadosMatricula = db.getListTurmaHasAluno(intent.extras.getString(EXTRA_CODIGOT))


        if (dadosMatricula.count == 0) {
            Log.d("TRABALHO", "lista vazia")
        } else {
            Log.d("loop codigos", "Entrou while")

            while (dadosMatricula.moveToNext()) {


                var codAluno = dadosMatricula.getString(0)

                Log.d("loop codigos", "codigo: " + codAluno)

                theListCodAluno.add(codAluno)

            }


            var theList = ArrayList<Aluno>()


            var dadosAlunos = db.getListAlunosPorTurma(theListCodAluno)


            if (dadosAlunos.count == 0) {

                Log.d("TRABALHO", "lista vazia")
            } else {


                while (dadosAlunos.moveToNext()) {

                    var alunoAux = Aluno(dadosAlunos.getString(dadosAlunos.getColumnIndex("matricula"))
                            , dadosAlunos.getString(dadosAlunos.getColumnIndex("nome"))
                            , dadosAlunos.getString(dadosAlunos.getColumnIndex("foto_url")),false)

                    theList.add(alunoAux)

                }



                val adapter = AlunoAdapter(this, theList)


                lista_aluno.adapter = adapter


                salvarChamada.setOnClickListener(View.OnClickListener {


                    var theList2 = adapter.getListaAtualizada()

                    val today = Calendar.getInstance()
                    val data = SimpleDateFormat("Y/d/M").format(today.time)


                    db.insertChamada(theList2, intent.extras.getString(EXTRA_CODIGOT),intent.extras.getString(EXTRA_CODIGOP) ,data)

                    Toast.makeText(this, "Chamada Concluída", Toast.LENGTH_LONG).show()

                    finish()

                })


            }

        }

    }

    /*

    Campo dos logs

    Log.d("checknaid", " posicao 0 -status: " + theList.get(0).marcado
                            + " posicao 1 -status: " + theList.get(1).marcado
                            + " posicao 2 -status: " + theList.get(2).marcado
                            + " posicao 3 -status: " + theList.get(3).marcado
                            + " posicao 4 -status: " + theList.get(4).marcado)



     */

}
