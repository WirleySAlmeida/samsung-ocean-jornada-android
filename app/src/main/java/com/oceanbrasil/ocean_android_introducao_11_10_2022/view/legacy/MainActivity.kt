package com.oceanbrasil.ocean_android_introducao_11_10_2022.view.legacy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.oceanbrasil.ocean_android_introducao_11_10_2022.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Detectar clique no botão
        //  a. Pegar o 'Button' pelo 'ID'
        //  b. Criar um listener para esse botão que foi encontrado
        // 2. Atualizar o conteúdo do TextView para o nosso nome
        //  a. Pegar o TextView pelo ID
        //  b. Atualizar a propriedade 'text' do TextView

        // Dentro de <> colocamos o TIPO da informação (ex: Button, TextView, EditText etc.)
        // Dentro de () colocamos o ID do elemento (ex: R.id.tvResultado, R.id.btEnviar etc.)

        // Variáveis em Kotlin começando com val ou var
        // Val = não muda o valor depois de inicializada
        // Var = permite a alteração do valor

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)



        // Para criar um listener para uma View (Button, TextView etc.), utilizamos a declaração setOnClickListener{}

        // Dentro das { } chaves do Listener, temos o código que é executado no momento que o Click (toque no botão) acontece
        btEnviar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                tvResultado.text = etNome.text
            } else {
                etNome.error = "Digite um nome"
            }
        }

        // Abrir Nova Tela

        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)

        btAbrirNovaTela.setOnClickListener {
            val novaTelaIntent = Intent(this, ResultadoActivity::class.java)

            // Inserimos novos dados nessa intent
            novaTelaIntent.putExtra("NOME_DIGITADO", etNome.text.toString())

            startActivity(novaTelaIntent)
        }
    }
}