package com.example.agendamc.Activity

import android.app.Application
import java.lang.IllegalStateException

class AgendaAplication:Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
    companion object {
        private var appInstance: AgendaAplication?  = null

        fun getInstance():AgendaAplication{
            if (appInstance == null){
                throw IllegalStateException("Configurar manifest")

            }
            return  appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}