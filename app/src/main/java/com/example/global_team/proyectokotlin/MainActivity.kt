package com.example.global_team.proyectokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
data class Cursos(val nombre:String,val url:String)
class MainActivity : AppCompatActivity() {
        val react = Cursos("React","react")
    val kot = Cursos("Kotlin","kotlin")
    var CursoActual = react.copy()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton =findViewById(R.id.botonsito) as Button
    boton.setOnClickListener {
       // view -> verEnPantalla("Ho señor me diste click ${react.nombre}")
        view -> switchCurso(CursoActual)
    }
        boton.setText(todosLosCursos())

    }
    fun switchCurso(curso:Cursos){
        CursoActual = curso.copy()
        when(curso.url){
            "react" -> CursoActual = kot.copy()
            "kotlin" -> CursoActual = react.copy()
            else -> print("No va a pasar")

        }
        verEnPantalla("Curso de ${CursoActual.nombre} en platzi.com/${CursoActual.url}")
    }
    fun verEnPantalla(s: String){
        var txt = findViewById(R.id.mensaje) as TextView
        txt.setText(s)
    }

    fun todosLosCursos() : String = "${react.nombre} ${kot.nombre}"
}
