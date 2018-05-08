package com.example.trabalhochamada

import android.content.Context
import android.database.Cursor
import android.os.Parcel
import android.os.Parcelable
import android.widget.ResourceCursorAdapter
import android.widget.TextView
import android.R.attr.name
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.trabalhochamada.R.id.*
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider


class AlunoAdapter (private val context: Context, private val dataSource: ArrayList<Aluno>) : BaseAdapter() {


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
        val rowView = inflater.inflate(R.layout.list_item_aluno, parent, false)


        val matricula =  rowView.findViewById<TextView>(R.id.aluno_matricula)
        val nome = rowView.findViewById<TextView>(R.id.aluno_nome)
        val foto = rowView.findViewById<ImageView>(R.id.aluno_foto)

        val aluno = getItem(position) as Aluno

        matricula.text = aluno.matricula
        nome.text = aluno.nome

        Picasso.get().load(aluno.imageUrl).placeholder(R.mipmap.ic_launcher).into(foto)

        return rowView
    }









}