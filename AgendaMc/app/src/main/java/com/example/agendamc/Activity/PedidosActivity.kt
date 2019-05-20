package com.example.agendamc.Activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.agendamc.Adpters.adapterPedidos
import com.example.agendamc.Notificationpush
import com.example.agendamc.R
import com.example.agendamc.rest.ListapedidosService
import kotlinx.android.synthetic.main.activity_pedidos.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.tollbar.toolbar

class PedidosActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var pedidos = listOf<PedidosList>()
    var recyclerpedidos: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val Toolbar = toolbar
        setSupportActionBar(Toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /*imgAtualizar.setOnClickListener {
            atualizacao()
        }*/

        recyclerpedidos = recyclePedido
        recyclerpedidos?.layoutManager = LinearLayoutManager(context)
        recyclerpedidos?.itemAnimator = DefaultItemAnimator()
        recyclerpedidos?.setHasFixedSize(true)



    }

   /* private fun atualizacao() {
        progress_bar.visibility = View.VISIBLE
        val handler = Handler()
        handler.postDelayed({progress_bar.visibility = View.GONE},10000)
    }*/
    override fun onResume() {
        super.onResume()
        // task para recuperar as disciplinas
        taskListapedido()
    }

    fun taskListapedido() {

        Thread {
            // que será executado em segundo plano
            this.pedidos = ListapedidosService.getListapedidos(context)
            runOnUiThread {
                recyclerpedidos?.adapter = adapterPedidos(this.pedidos) {onClickPedidos(it) }
                enviarNotification(this.pedidos.get(0))
            }
        }.start()

    }
    fun enviarNotification(pedido:PedidosList){
        val intent = Intent(this, PedidosActivity::class.java)
        intent.putExtra("pedidos",pedido)
        Notificationpush.create(1,intent,"Novo pedido","Pedidos")
    }

       /* pedidos = ListapedidosService.getListapedidos(context)
        // atualizar lista
        recyclerpedidos?.adapter = adapterPedidos(pedidos) {onClickPedidos(it)}*/



    fun onClickPedidos(pedido:PedidosList){
        Toast.makeText(context, "Clicou no Pedido ${pedido.typeService}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, PedidosActivity::class.java)
        intent.putExtra("Pedido", pedido)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent6 = Intent(this, ConfigActivity::class.java)
        when (item.itemId) {
            R.id.action_buscar ->{
                Toast.makeText(this@PedidosActivity, "Botão de buscar",
                    Toast.LENGTH_LONG).show()
            }
            R.id.action_atu ->{
                progressBar?.visibility = View.VISIBLE
                val handler = Handler()
                handler.postDelayed({progressBar?.visibility = View.GONE},10000)
            }
            R.id.action_cadastro ->{
            val intent8 = Intent(this, CadastroPedidoActivity::class.java)
                startActivity(intent8)
            }
        }

        return super.onOptionsItemSelected(item)
    }



}
