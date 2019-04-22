package com.example.agendamc.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_pedidos.*
import kotlin.random.Random

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        val Toolbar = toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

       btnCadastrar.setOnClickListener {
           gerarPedido(editTipodeservico.text.toString())
       }
    }
    fun gerarPedido(npedido: String) {
        if(npedido != null) {
           Toast.makeText(this@CadastroActivity,"Pedido Cadastrado",Toast.LENGTH_SHORT).show()
        }
    }
}
