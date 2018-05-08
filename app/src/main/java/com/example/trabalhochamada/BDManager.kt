package com.example.trabalhochamada

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.FileObserver.CREATE
import android.util.Log

val NOME_BD = "betaBD17"

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
val COLUNA_IDP_FK = "idp_fk"

//Turma_has_Aluno
val NOME_TABELATHA = "turma_has_aluno"
val COLUNA_IDTHA = "id"
val COLUNA_CODIGOT_FK = "codigot_fk"
val COLUNA_MATRICULAA_FK = "matircula_fk"




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
                COLUNA_CODIGOT+ " VARCHAR, " +
                COLUNA_HORAT+ " VARCHAR(5), " +
                COLUNA_SALAT+ " INTEGER, " +
                COLUNA_DISCIPLINAT+ " VARCHAR(50), " +
                COLUNA_IDP_FK+ " INTEGER) "

        val createTabelaHasAluno = "CREATE TABLE " +NOME_TABELATHA+ " (" +
                COLUNA_IDTHA+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_CODIGOT_FK+ " VARCHAR, " +
                COLUNA_MATRICULAA_FK+ "  VARCHAR(9)) "



        db?.execSQL(createTabelaProfessor)
        db?.execSQL(createTabelaAluno)
        db?.execSQL(createTabelaTurma)
        db?.execSQL(createTabelaHasAluno)

        //Inserir Professor
        var professor1 = ContentValues()
        var professor2 = ContentValues()

        professor1.put(COLUNA_LOGINP, "jorel")
        professor1.put(COLUNA_SENHAP, "12345")

        professor2.put(COLUNA_LOGINP, "silvio")
        professor2.put(COLUNA_SENHAP, "54321")

        db?.insert(NOME_TABELAP,null,professor1)
        db?.insert(NOME_TABELAP,null,professor2)

        //Inserir Alunos
        var aluno1 = ContentValues()
        var aluno2 = ContentValues()
        var aluno3 = ContentValues()
        var aluno4 = ContentValues()
        var aluno5 = ContentValues()
        var aluno6 = ContentValues()
        var aluno7 = ContentValues()
        var aluno8 = ContentValues()
        var aluno9 = ContentValues()
        var aluno10 = ContentValues()


        aluno1.put(COLUNA_MATRICULAA, "029141084")
        aluno1.put(COLUNA_NOMEA, "Akira Fudou")
        aluno1.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/8/348040.jpg")

        aluno2.put(COLUNA_MATRICULAA, "046987464")
        aluno2.put(COLUNA_NOMEA, "Ryou Asuka")
        aluno2.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/2/348039.jpg")

        aluno3.put(COLUNA_MATRICULAA, "478569879")
        aluno3.put(COLUNA_NOMEA, "Miki Makimura")
        aluno3.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/10/347856.jpg")

        aluno4.put(COLUNA_MATRICULAA, "879587645")
        aluno4.put(COLUNA_NOMEA, "Rintarou Okabe")
        aluno4.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/5/258813.jpg")

        aluno5.put(COLUNA_MATRICULAA, "378643254")
        aluno5.put(COLUNA_NOMEA, "Kurisu Makise")
        aluno5.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/10/114399.jpg")

        aluno6.put(COLUNA_MATRICULAA, "915687457")
        aluno6.put(COLUNA_NOMEA, "Itaru Hashida")
        aluno6.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/6/113767.jpg")

        aluno7.put(COLUNA_MATRICULAA, "648754455")
        aluno7.put(COLUNA_NOMEA, "Suzuha Amane")
        aluno7.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/11/113764.jpg")

        aluno8.put(COLUNA_MATRICULAA, "684957214")
        aluno8.put(COLUNA_NOMEA, "Shoutarou Kaneda")
        aluno8.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/6/307013.jpg")

        aluno9.put(COLUNA_MATRICULAA, "668754245")
        aluno9.put(COLUNA_NOMEA, "Tetsuo Shima")
        aluno9.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/16/310479.jpg")

        aluno10.put(COLUNA_MATRICULAA, "258764338")
        aluno10.put(COLUNA_NOMEA, "Claire Stanfield ")
        aluno10.put(COLUNA_FOTOA, "https://myanimelist.cdn-dena.com/images/characters/8/35457.jpg")


        db?.insert(NOME_TABELAA,null,aluno1)
        db?.insert(NOME_TABELAA,null,aluno2)
        db?.insert(NOME_TABELAA,null,aluno3)
        db?.insert(NOME_TABELAA,null,aluno4)
        db?.insert(NOME_TABELAA,null,aluno5)
        db?.insert(NOME_TABELAA,null,aluno6)
        db?.insert(NOME_TABELAA,null,aluno7)
        db?.insert(NOME_TABELAA,null,aluno8)
        db?.insert(NOME_TABELAA,null,aluno9)
        db?.insert(NOME_TABELAA,null,aluno10)




        //Inserir Turma

        var turma1 = ContentValues()
        var turma2 = ContentValues()
        var turma3 = ContentValues()
        var turma4 = ContentValues()


        turma1.put(COLUNA_CODIGOT, "MR-01")
        turma1.put(COLUNA_HORAT, "7:00 - 8:30")
        turma1.put(COLUNA_SALAT, 502)
        turma1.put(COLUNA_DISCIPLINAT, "Filosofia")
        turma1.put(COLUNA_IDP_FK, 1)


        turma2.put(COLUNA_CODIGOT, "MR-02")
        turma2.put(COLUNA_HORAT, "8:30 - 10:00")
        turma2.put(COLUNA_SALAT, 401)
        turma2.put(COLUNA_DISCIPLINAT, "Historia")
        turma2.put(COLUNA_IDP_FK, 1)


        turma3.put(COLUNA_CODIGOT, "MR-03")
        turma3.put(COLUNA_HORAT, "7:00 - 8:30")
        turma3.put(COLUNA_SALAT, 204)
        turma3.put(COLUNA_DISCIPLINAT, "Matematica")
        turma3.put(COLUNA_IDP_FK, 2)

        turma4.put(COLUNA_CODIGOT, "MR-04")
        turma4.put(COLUNA_HORAT, "8:30 - 10:00")
        turma4.put(COLUNA_SALAT, 206)
        turma4.put(COLUNA_DISCIPLINAT, "Fisica")
        turma4.put(COLUNA_IDP_FK, 2)

        db?.insert(NOME_TABELAT,null,turma1)
        db?.insert(NOME_TABELAT,null,turma2)
        db?.insert(NOME_TABELAT,null,turma3)
        db?.insert(NOME_TABELAT,null,turma4)


        //Inserir Tabela has Aluno

        var tha1 = ContentValues()
        var tha2 = ContentValues()
        var tha3 = ContentValues()
        var tha4 = ContentValues()
        var tha5 = ContentValues()
        var tha6 = ContentValues()
        var tha7 = ContentValues()
        var tha8 = ContentValues()
        var tha9 = ContentValues()
        var tha10 = ContentValues()

        var tha11 = ContentValues()
        var tha12 = ContentValues()
        var tha13 = ContentValues()
        var tha14 = ContentValues()
        var tha15 = ContentValues()
        var tha16 = ContentValues()
        var tha17 = ContentValues()
        var tha18 = ContentValues()
        var tha19 = ContentValues()
        var tha20 = ContentValues()

        tha1.put(COLUNA_CODIGOT_FK, "MR-01")
        tha1.put(COLUNA_MATRICULAA_FK,"029141084")

        tha2.put(COLUNA_CODIGOT_FK, "MR-01")
        tha2.put(COLUNA_MATRICULAA_FK,"046987464")

        tha3.put(COLUNA_CODIGOT_FK, "MR-01")
        tha3.put(COLUNA_MATRICULAA_FK,"478569879")

        tha4.put(COLUNA_CODIGOT_FK, "MR-01")
        tha4.put(COLUNA_MATRICULAA_FK,"879587645")

        tha5.put(COLUNA_CODIGOT_FK, "MR-01")
        tha5.put(COLUNA_MATRICULAA_FK,"378643254")

        tha6.put(COLUNA_CODIGOT_FK, "MR-02")
        tha6.put(COLUNA_MATRICULAA_FK,"915687457")

        tha7.put(COLUNA_CODIGOT_FK, "MR-02")
        tha7.put(COLUNA_MATRICULAA_FK,"648754455")

        tha8.put(COLUNA_CODIGOT_FK, "MR-02")
        tha8.put(COLUNA_MATRICULAA_FK,"684957214")

        tha9.put(COLUNA_CODIGOT_FK, "MR-02")
        tha9.put(COLUNA_MATRICULAA_FK,"668754245")

        tha10.put(COLUNA_CODIGOT_FK, "MR-02")
        tha10.put(COLUNA_MATRICULAA_FK,"258764338")

        tha11.put(COLUNA_CODIGOT_FK, "MR-03")
        tha11.put(COLUNA_MATRICULAA_FK,"029141084")

        tha12.put(COLUNA_CODIGOT_FK, "MR-03")
        tha12.put(COLUNA_MATRICULAA_FK,"046987464")

        tha13.put(COLUNA_CODIGOT_FK, "MR-03")
        tha13.put(COLUNA_MATRICULAA_FK,"478569879")

        tha14.put(COLUNA_CODIGOT_FK, "MR-03")
        tha14.put(COLUNA_MATRICULAA_FK,"879587645")

        tha15.put(COLUNA_CODIGOT_FK, "MR-03")
        tha15.put(COLUNA_MATRICULAA_FK,"378643254")

        tha16.put(COLUNA_CODIGOT_FK, "MR-04")
        tha16.put(COLUNA_MATRICULAA_FK,"915687457")

        tha17.put(COLUNA_CODIGOT_FK, "MR-04")
        tha17.put(COLUNA_MATRICULAA_FK,"648754455")

        tha18.put(COLUNA_CODIGOT_FK, "MR-04")
        tha18.put(COLUNA_MATRICULAA_FK,"684957214")

        tha19.put(COLUNA_CODIGOT_FK, "MR-04")
        tha19.put(COLUNA_MATRICULAA_FK,"668754245")

        tha20.put(COLUNA_CODIGOT_FK, "MR-04")
        tha20.put(COLUNA_MATRICULAA_FK,"258764338")

        db?.insert(NOME_TABELATHA,null,tha1)
        db?.insert(NOME_TABELATHA,null,tha2)
        db?.insert(NOME_TABELATHA,null,tha3)
        db?.insert(NOME_TABELATHA,null,tha4)
        db?.insert(NOME_TABELATHA,null,tha5)
        db?.insert(NOME_TABELATHA,null,tha6)
        db?.insert(NOME_TABELATHA,null,tha7)
        db?.insert(NOME_TABELATHA,null,tha8)
        db?.insert(NOME_TABELATHA,null,tha9)
        db?.insert(NOME_TABELATHA,null,tha10)
        db?.insert(NOME_TABELATHA,null,tha11)
        db?.insert(NOME_TABELATHA,null,tha12)
        db?.insert(NOME_TABELATHA,null,tha13)
        db?.insert(NOME_TABELATHA,null,tha14)
        db?.insert(NOME_TABELATHA,null,tha15)
        db?.insert(NOME_TABELATHA,null,tha16)
        db?.insert(NOME_TABELATHA,null,tha17)
        db?.insert(NOME_TABELATHA,null,tha18)
        db?.insert(NOME_TABELATHA,null,tha19)
        db?.insert(NOME_TABELATHA,null,tha20)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun verificaLogin(usuario: Professor) : ContentValues{

        //criação da query utilizando os dados recebidos de login e senha para consulta
        val query = "SELECT * FROM " +NOME_TABELAP+ " WHERE " +COLUNA_LOGINP+ " = '" +usuario.login+ "' AND " +COLUNA_SENHAP+ " = '" +usuario.senha+"';"

        val db = this.writableDatabase

        //receber dados da execução da query
        val cursor = db.rawQuery(query,null)

        var validaUsuario = ContentValues()

        validaUsuario.put("check",false)


        //caso a query possua algum resultado retorna true
        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            validaUsuario.put("check",true)
            validaUsuario.put("id",cursor.getInt(0))

            cursor.close()
        }

        db.close()

        return validaUsuario

    }


    fun getListTurmaHasAluno(codTurma: String) : Cursor {

        Log.d("zza", "Entrou turmhasaluno" )
        val query = "SELECT "+COLUNA_MATRICULAA_FK+ " FROM " +NOME_TABELATHA+ " WHERE " +COLUNA_CODIGOT_FK+ " = '" +codTurma+ "'"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query,null)

        return cursor

    }

    fun getListAlunosPorTurma(theListCodAluno : ArrayList<String>) : Cursor {
        Log.d("zza", "Entrou get list aluno" )

        var where :String = " WHERE ";

        var i = 0
        var iend= theListCodAluno.size


        while (i<iend) {
            Log.d("loopasd", "começou: " + i)

            where = where +COLUNA_MATRICULAA + " = '" + theListCodAluno.get(i)+"'"

            if(i<iend-1){

                where = where + " OR "
            }

            i++
       }


        Log.d("WHERE1", "Saida: " + where)


        val query = "SELECT * FROM " +NOME_TABELAA+ where

        val db = this.writableDatabase

        val cursor = db.rawQuery(query,null)

        return cursor

    }

    fun getList2(id_professor: String) : Cursor {

        val query = "SELECT * FROM " +NOME_TABELAT+ " WHERE " +COLUNA_IDP_FK+ " = '" +id_professor+"'"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query,null)

        return cursor

    }





}