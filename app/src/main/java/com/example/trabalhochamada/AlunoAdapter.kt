package com.example.trabalhochamada


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso


class AlunoAdapter (private val context: Context, private val dataSource: ArrayList<Aluno>) : BaseAdapter() {


    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return dataSource.size
    }


    override fun getItem(position: Int): Aluno {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        Log.d("TRABALHO", "entrou no get view")


        val rowView = inflater.inflate(R.layout.list_item_aluno, parent, false)


        val matricula =  rowView.findViewById<TextView>(R.id.aluno_matricula)
        val nome = rowView.findViewById<TextView>(R.id.aluno_nome)
        val foto = rowView.findViewById<ImageView>(R.id.aluno_foto)
        var checkbox = rowView.findViewById<CheckBox>(R.id.checkBoxFalta)

        val aluno = getItem(position) as Aluno

        matricula.text = "Matricula: " +aluno.matricula
        nome.text = "Nome: " + aluno.nome
        checkbox.isChecked = aluno.marcado


        Picasso.get().load(aluno.imageUrl).placeholder(R.mipmap.ic_launcher).into(foto)


        checkbox.setOnClickListener(View.OnClickListener {

                //cANDid.put(position.toString(),checkbox.isChecked)

                dataSource.get(position).teste(checkbox.isChecked)


        })

        return rowView
    }


    fun getListaAtualizada() : ArrayList<Aluno>{

        return dataSource

    }


}