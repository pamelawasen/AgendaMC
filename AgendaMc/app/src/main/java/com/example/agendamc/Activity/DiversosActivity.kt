package com.example.agendamc.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_diversos.*
import kotlinx.android.synthetic.main.app_bar_home.*

class DiversosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diversos)


       val Toolbar2 = toolbar7
        setSupportActionBar(Toolbar2)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}
