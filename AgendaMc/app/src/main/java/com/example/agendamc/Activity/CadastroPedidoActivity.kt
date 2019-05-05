package com.example.agendamc.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.agendamc.R
import com.example.agendamc.rest.ListapedidosService
import kotlinx.android.synthetic.main.activity_cadastro_pedido.*
import kotlinx.android.synthetic.main.tollbar.*

class CadastroPedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_pedido)
        setTitle("Cadastro de pedido")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val Toolbar = toolbar
        setSupportActionBar(Toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btncadastraPedido.setOnClickListener {
        val cpedido = PedidosList()
            cpedido.client = editNomecli.text.toString()
            cpedido.adress = editEndereço.text.toString()
            cpedido.typeService = editService.text.toString()

            atualizar(cpedido)
        }
    }

    fun atualizar(cpedido:PedidosList){
        Thread{
        ListapedidosService.save(cpedido)
            runOnUiThread {
                finish()
            }
        }.start()

    }

}
