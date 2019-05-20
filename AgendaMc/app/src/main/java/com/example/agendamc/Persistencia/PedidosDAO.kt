package com.example.agendamc.Persistencia

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.agendamc.Activity.PedidosList


@Dao
interface PedidosDAO {

    @Query("SELECT * FROM pedidos where id = :id")
    fun getById(id: Long) : PedidosList?

    @Query("SELECT * FROM pedidos")
    fun findAll(): List<PedidosList>

    @Insert
    fun insert(pedidosList: PedidosList)

    @Delete
    fun delete(pedidosList: PedidosList)
}