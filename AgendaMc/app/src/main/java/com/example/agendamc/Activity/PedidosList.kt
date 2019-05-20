package com.example.agendamc.Activity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "pedidos")
class PedidosList : Serializable {

    @PrimaryKey
        var id:Long = 0
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
