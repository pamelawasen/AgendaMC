package com.example.agendamc.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_buscar.*
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.tollbar.*

class BuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)


        val Toolbar = toolbar
        setSupportActionBar(Toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnBuscar.setOnClickListener {
            busca(editBusca.text.toString())
        }
    }

    fun busca(busca:String){
        Toast.makeText(this@BuscarActivity,"$busca",Toast.LENGTH_SHORT).show()
    }
}


