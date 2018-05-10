package com.example.trabalhochamada


class Turma(var codigo: String,
            var hora: String,
            var dia: Int,
            var sala: Int,
            var disciplina: String) {


    fun convertDia(): String{

        val diaSemana = when(dia) {
            1 -> "Domingo"
            2 -> "Segunda"
            3 -> "Terça"
            4 -> "Quarta"
            5 -> "Quinta"
            6 -> "Sexta"
            7 -> "Saturday"
            else -> "Dia Invalido"

        }

        return diaSemana
    }

}