package com.example.calculadoradeimc

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val altura = findViewById<EditText>(R.id.etAltura)
        val peso = findViewById<EditText>(R.id.etPeso)
        val botao = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val classificacao = findViewById<TextView>(R.id.tvClassificacao)

        botao.setOnClickListener {
            val altura2 = altura.text.toString().toFloat()
            val peso2 = peso.text.toString().toFloat()
            val calculo = peso2 / (altura2*altura2)
            val novoResultado = DecimalFormat("#.##").format(calculo)

            resultado.text = novoResultado

            fun calcular(calculo:Float): String {
                return when (calculo){
                    in 0.01..18.5 -> "Você está abaixo do peso ideal"
                    in 18.6..24.9 -> "Você está no peso ideal"
                    in 25.0..29.9 -> "Você está acima do peso ideal"
                    in 30.0..34.9 -> "Você está com obesidade Grau 1"
                    in 35.0..39.9 -> "Você está com obesidade Grau 2"
                    in 40.0..1000.0 -> "Você está com obesidade Grau 3 ou mórbida"
                    else -> ""
                }
            }
            classificacao.text = calcular(calculo)
        }

        btnLimpar.setOnClickListener{
             altura.text.clear()
             peso.text.clear()
             resultado.text = ""
             classificacao.text = ""
        }
    }
}