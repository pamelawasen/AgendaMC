package com.example.agendamc.Activity

import com.google.gson.GsonBuilder
import java.io.Serializable

class PedidosList:Serializable {

        var client = ""
        var adress = ""
        var typeService = ""

        override fun toString(): String {
            return "Lista de Pedidos $typeService"
        }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
    }
