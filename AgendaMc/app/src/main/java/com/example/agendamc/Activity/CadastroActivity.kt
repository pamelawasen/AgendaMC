package com.example.agendamc.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.tollbar.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val Toolbar = toolbar
        setSupportActionBar(Toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

       btncadastraPedido.setOnClickListener {
           gerarPedido(editTipodeservico.text.toString())
       }
    }
    fun gerarPedido(npedido: String) {
        if(npedido != null) {
           Toast.makeText(this@CadastroActivity,"Pedido Cadastrado",Toast.LENGTH_SHORT).show()
        }
    }
}
