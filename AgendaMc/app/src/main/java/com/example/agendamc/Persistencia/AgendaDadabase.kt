package com.example.agendamc.Persistencia

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.agendamc.Activity.PedidosList


@Database(entities = arrayOf(PedidosList::class),version = 4)
        abstract class AgendaDadabase:RoomDatabase() {
                abstract fun PedidosDAO():PedidosDAO

}