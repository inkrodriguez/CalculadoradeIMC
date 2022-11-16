package com.example.calculadoradeimc

import android.icu.text.DecimalFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val altura = findViewById<EditText>(R.id.etAltura)
        val peso = findViewById<EditText>(R.id.etPeso)
        val botao = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
        var resultado = findViewById<TextView>(R.id.tvResultado)

        botao.setOnClickListener{
            val editAltura = altura.text.toString().toFloat()
            val editPeso = peso.text.toString().toFloat()

            val calculo = editPeso / (editAltura*editAltura)

            val decimal = DecimalFormat(".00")
            val calculoFormatado = decimal.format(calculo)

            resultado.text = calculoFormatado.toString()
        }

        btnLimpar.setOnClickListener{
             altura.text.clear()
             peso.text.clear()
             resultado.text = ""

        }

    }
}