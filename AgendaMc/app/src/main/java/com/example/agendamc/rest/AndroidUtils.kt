package com.example.agendamc.rest

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.support.annotation.RequiresApi

object AndroidUtils {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun isInternetDisponivel(context: Context): Boolean {
        val conexao = context.getSystemService(Context.CONNECTIVITY_SERVICE)  as ConnectivityManager

        val redes = conexao.allNetworks
        return redes.map{conexao.getNetworkInfo(it)}.any{it.state == NetworkInfo.State.CONNECTED}
    }
}