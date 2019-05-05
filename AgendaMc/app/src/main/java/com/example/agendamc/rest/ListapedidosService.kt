package com.example.agendamc.rest

import android.content.Context
import android.util.Log
import com.example.agendamc.Activity.PedidosList
import com.example.agendamc.Activity.Response
import com.example.agendamc.Adpters.adapterPedidos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL


object ListapedidosService {

    val host = "http://192.168.15.13:3000"
    val TAG = "WS_LMSApp"

        fun getListapedidos(context: Context):List<PedidosList> {

            val url = "$host/get/orders"
            val json = HttpHelper.get(url)

            Log.d(TAG, json)

            return parserJson(json)
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

