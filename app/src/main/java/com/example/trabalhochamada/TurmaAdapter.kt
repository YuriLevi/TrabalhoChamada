package com.example.trabalhochamada

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class TurmaAdapter(private val context: Context, private val dataSource: ArrayList<Turma>) : BaseAdapter() {


    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d("TRABALHO", "entrou no get view")

        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_turma, parent, false)


        val codigo =  rowView.findViewById<TextView>(R.id.turma_codigo)
        val hora = rowView.findViewById<TextView>(R.id.turma_hora)
        val sala = rowView.findViewById<TextView>(R.id.turma_sala)
        val disciplina = rowView.findViewById<TextView>(R.id.turma_disciplina)
        val dia = rowView.findViewById<TextView>(R.id.turma_dia)


        val turma = getItem(position) as Turma

        codigo.text = "Turma: " + turma.codigo
        dia.text = "Dia: " + turma.convertDia()
        hora.text = "Horario: " + turma.hora
        sala.text = "Sala: " + turma.sala
        disciplina.text = "Disciplina: " + turma.disciplina


        return rowView
    }
}