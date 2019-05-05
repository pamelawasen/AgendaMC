package com.example.agendamc.Adpters

import android.os.Handler
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.example.agendamc.Activity.PedidosList
import com.example.agendamc.R
import kotlinx.android.synthetic.main.adpter_listapedidos.view.*
import java.text.FieldPosition

class adapterPedidos (

    val pedido:List<PedidosList>,
    val onclick:(PedidosList) -> Unit):RecyclerView.Adapter<adapterPedidos.ListapedidosViewHolder>(){

    class ListapedidosViewHolder(view: View):RecyclerView.ViewHolder(view){
        val cardNome:TextView
        val cardBody:TextView
        val cardProgress:ProgressBar
        var cardView:CardView

        init {
            cardNome = view.cardNome
            cardProgress = view.cardprogress
            cardView = view.cardlistap
            cardBody = view.cardbody
        }
    }
    //mostra a quantidade da lista
    override fun getItemCount()= this.pedido.size

    //infla o layout adapter
    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int): ListapedidosViewHolder {
        //infla a view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adpter_listapedidos,parent,false)
        val holder = ListapedidosViewHolder(view)
        return holder

    }

    // atualiza os dados da view
    override fun onBindViewHolder(holder: ListapedidosViewHolder, position: Int) {
    val context = holder.itemView.context

    //recupera o objeto pedido
    val pedidos1 =  this.pedido[position]


        holder.cardNome.text = pedidos1.client
        holder.cardBody.text = pedidos1.typeService
        holder.cardProgress.visibility = View.GONE
        holder.itemView.setOnClickListener {onclick(pedidos1)}
        }
    }



