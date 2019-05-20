package com.example.agendamc.rest

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import com.example.agendamc.Activity.PedidosList
import com.example.agendamc.Activity.Response
import com.example.agendamc.Adpters.adapterPedidos
import com.example.agendamc.Persistencia.DatabaseManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL


object ListapedidosService {

    val host = "http://172.20.1.35:3000"
    val TAG = "WS_App"
    val dao = DatabaseManager.getPeidoDAO()


        fun getListapedidos(context: Context):List<PedidosList> {

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            if (AndroidUtils.isInternetDisponivel(context)) {

                val url = "$host/get/orders"
                val json = HttpHelper.get(url)
                val pedidos: List<PedidosList> = parserJson(json)

                for (d in pedidos) {
                    if(dao.getById(d.id)== null){
                        dao.insert(d)
                    }

                }
                return pedidos
            }else{
                return dao.findAll()
            }

        }
            fun save(pedido:PedidosList):Response{
                var json = HttpHelper.post("$host/order",pedido.toJson())
                return parserJson(json)
            }
            inline fun <reified T> parserJson(json: String): T {
                val type = object : TypeToken<T>(){}.type
                return Gson().fromJson<T>(json, type)
            }

        }





            /*val listapedido = mutableListOf<PedidosList>()

            for (n in 1..10){
                val q = PedidosList()
                q.numeropedido = "210 $n"
                q.nomecliente = "Thaiana $n"
                q.dataentrega = "20/10/2019 $n"

                listapedido.add(q)
            }
            return listapedido
        }*/

