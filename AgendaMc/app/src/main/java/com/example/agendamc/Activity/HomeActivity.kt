package com.example.agendamc.Activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.agendamc.R
import kotlinx.android.synthetic.main.activity_diversos.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        btnCli.setOnClickListener {
            clientcli(supportActionBar!!.title)
        }
        btnEstoque.setOnClickListener {
            estoquecli(supportActionBar!!.title)
        }

        btnOrca.setOnClickListener {
            orcacli(supportActionBar!!.title)
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }

    private fun orcacli(titulo: CharSequence?) {
        val intent7 = Intent(this, DiversosActivity::class.java)
        startActivity(intent7)
        val titulo ="Orçamento"
        supportActionBar!!.title = titulo
    }

    private fun estoquecli(titulo1: CharSequence?) {
        val titulo1 ="Estoque"
        supportActionBar?.title = titulo1
        val intent7 = Intent(this, DiversosActivity::class.java)
        startActivity(intent7)
    }

    private fun clientcli(titulo2: CharSequence?) {
        val titulo2 ="Cliente"
        supportActionBar?.title = titulo2
        val intent7 = Intent(this, DiversosActivity::class.java)
        startActivity(intent7)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent6 = Intent(this, ConfigActivity::class.java)
        when (item.itemId) {
            R.id.action_settings ->
                startActivity(intent6)
        }
        return true
    }

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
