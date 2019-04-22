package com.example.agendamc.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_pedidos.*

class PedidosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        val Toolbar = toolbar1
        setSupportActionBar(toolbar1)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        imgAtualizar.setOnClickListener {
            atualizacao()
        }

    }

    private fun atualizacao() {
        progress_bar.visibility = View.VISIBLE
        val handler = Handler()
        handler.postDelayed({progress_bar.visibility = View.GONE},10000)
    }
    class listapedidos{
        var numeropedido = ""
        var nomecliente = ""
    }

}
