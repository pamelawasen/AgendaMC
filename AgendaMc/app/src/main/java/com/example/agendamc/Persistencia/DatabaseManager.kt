package com.example.agendamc.Persistencia

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.agendamc.Activity.AgendaAplication

object DatabaseManager {

    private var dbInstant:AgendaDadabase

    init {
        val context = AgendaAplication.getInstance().applicationContext
        dbInstant = Room.databaseBuilder(context,
            AgendaDadabase::class.java, "agenda.sqlite")
            .fallbackToDestructiveMigration()
            .build()

    }
    fun getPeidoDAO(): PedidosDAO {
        return dbInstant.PedidosDAO()
    }
}