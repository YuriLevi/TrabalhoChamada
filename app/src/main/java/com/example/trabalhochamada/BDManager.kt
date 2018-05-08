package com.example.trabalhochamada

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.FileObserver.CREATE
import android.util.Log

val NOME_BD = "betaBD5"

//Professor
val NOME_TABELAP = "professor"
val COLUNA_IDP = "id"
val COLUNA_LOGINP = "login"
val COLUNA_SENHAP = "senha"

//Aluno
val NOME_TABELAA = "aluno"
val COLUNA_IDA = "id"
val COLUNA_MATRICULAA = "matricula"
val COLUNA_NOMEA = "nome"
val COLUNA_FOTOA = "foto_url"

//Turma
val NOME_TABELAT = "turma"
val COLUNA_IDT = "id"
val COLUNA_CODIGOT = "codigo"
val COLUNA_HORAT = "hora"
val COLUNA_SALAT = "sala"
val COLUNA_DISCIPLINAT = "disciplina"
val COLUNA_IDPFK = "idpfk"






class BDManager(context: Context) : SQLiteOpenHelper(context, NOME_BD,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        //criação da tabela professor
        val createTabelaProfessor = "CREATE TABLE " +NOME_TABELAP+ " (" +
                COLUNA_IDP+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_LOGINP+ " VARCHAR(256), " +
                COLUNA_SENHAP+ " VARCHAR(256)) "

        val createTabelaAluno= "CREATE TABLE " +NOME_TABELAA+ " (" +
                COLUNA_IDA+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_MATRICULAA+ " VARCHAR(9), " +
                COLUNA_NOMEA+ " VARCHAR(256), " +
                COLUNA_FOTOA+ " VARCHAR(256)) "

        val createTabelaTurma= "CREATE TABLE " +NOME_TABELAT+ " (" +
                COLUNA_IDT+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_CODIGOT+ " INTEGER, " +
                COLUNA_HORAT+ " VARCHAR(5), " +
                COLUNA_SALAT+ " INTEGER, " +
                COLUNA_DISCIPLINAT+ " VARCHAR(50), " +
                COLUNA_IDPFK+ " INTEGER) "

        db?.execSQL(createTabelaProfessor)
        db?.execSQL(createTabelaAluno)
        db?.execSQL(createTabelaTurma)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //carga de dados para teste
    fun cargaDados(){

        Log.d("TRABALHO" , "ENTROU INSERT")

        val db = this.writableDatabase

        var cvp = ContentValues()

        var cvA1 = ContentValues()
        var cvA2 = ContentValues()

        var cvT = ContentValues()

        cvp.put(COLUNA_LOGINP, "1")
        cvp.put(COLUNA_SENHAP, "1")

        cvA1.put(COLUNA_MATRICULAA, "029141084")
        cvA1.put(COLUNA_NOMEA, "Yuri Levi Lima Do Rosario")
        cvA1.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/8/348040.jpg")

        cvA2.put(COLUNA_MATRICULAA, "04698746d")
        cvA2.put(COLUNA_NOMEA, "Levi Rosario Yuri Lima")
        cvA2.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/2/348039.jpg")

        cvT.put(COLUNA_CODIGOT, 41577)
        cvT.put(COLUNA_HORAT, "8:30")
        cvT.put(COLUNA_SALAT, 401)
        cvT.put(COLUNA_DISCIPLINAT, "LTP II")
        cvT.put(COLUNA_IDPFK, 1)




        db.insert(NOME_TABELAP,null,cvp)

        db.insert(NOME_TABELAA,null,cvA1)
        db.insert(NOME_TABELAA,null,cvA2)

        db.insert(NOME_TABELAT,null,cvT)

        db.close()

    }

    fun verificaLogin(usuario: Professor) : Boolean{

        //criação da query utilizando os dados recebidos de login e senha para consulta
        val query = "SELECT * FROM " +NOME_TABELAP+ " WHERE " +COLUNA_LOGINP+ " = '" +usuario.login+ "' AND " +COLUNA_SENHAP+ " = '" +usuario.senha+"';"

        val db = this.writableDatabase

        //receber dados da execução da query
        val cursor = db.rawQuery(query,null)

        var validaUsuario = false

        //caso a query possua algum resultado retorna true
        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            validaUsuario = true

            cursor.close()
        }

        db.close()

        return validaUsuario

    }


    fun getList() : Cursor {

        val query = "SELECT * FROM " +NOME_TABELAA

        val db = this.writableDatabase

        val cursor = db.rawQuery(query,null)

        return cursor

    }


}