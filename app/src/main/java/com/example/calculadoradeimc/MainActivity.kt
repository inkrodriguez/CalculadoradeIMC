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
            val editAltura = altura.text.toString().toFloat()
            val editPeso = peso.text.toString().toFloat()

            val calculo = editPeso / (editAltura*editAltura)

            val decimal = DecimalFormat(".00")
            val calculoFormatado = decimal.format(calculo)

            resultado.text = calculoFormatado.toString()

            if (calculo <= 18.5) {
                classificacao.text = "Você está abaixo do peso."
            }
            else if (calculo >= 18.6 && calculo <= 24.9){
                classificacao.text = "Você está no peso ideal, parabéns!"
            }
            else if (calculo >= 25.0 && calculo <= 29.9){
                classificacao.text = "Você está levemente acima do peso."
            }
            else if (calculo >= 30.0 && calculo <= 34.9){
                classificacao.text = "Você está com obesidade grau 1"
            }
            else if (calculo >= 35.0 && calculo <= 39.9){
                classificacao.text = "Você está com obesidade grau 2"
            }
            else if (calculo >= 40.0){
                classificacao.text = "Você está com obesidade grau 3"
            }
        }

        btnLimpar.setOnClickListener{
             altura.text.clear()
             peso.text.clear()
             resultado.text = ""
             classificacao.text = ""

        }

    }
}