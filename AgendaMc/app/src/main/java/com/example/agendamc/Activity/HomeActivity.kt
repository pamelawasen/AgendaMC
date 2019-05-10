package com.example.agendamc.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*



class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )




        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }




    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent6 = Intent(this, ConfigActivity::class.java)
        when (item.itemId) {
            R.id.action_buscar ->{
                Toast.makeText(this@HomeActivity, "Botão de buscar",
                    Toast.LENGTH_LONG).show()
        }
        R.id.action_atu ->{
            progressBar?.visibility = View.VISIBLE
            val handler = Handler()
            handler.postDelayed({progressBar?.visibility = View.GONE},10000)
            }
        }

        return super.onOptionsItemSelected(item)
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // visualização de menu lateral.
        when (item.itemId) {
            R.id.nav_buscar ->{
                val intent = Intent(this, BuscarActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_pedidos -> {
                val intent5 = Intent(this, PedidosActivity::class.java)
                startActivity(intent5)
            }

            R.id.nav_cadastro -> {
                val intent4 = Intent(this, CadastroActivity::class.java)
                startActivity(intent4)
            }

            R.id.nav_sair -> {
                val intent4 = Intent(this, LoginActivity::class.java)
                startActivity(intent4)
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
