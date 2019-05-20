package com.example.agendamc

import android.content.Intent
import android.util.Log
import com.example.agendamc.Activity.PedidosActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    val tag ="AgendaFirebase"



    override fun onNewToken(token:String){
        super.onNewToken(token)
        Log.d("fb_token",token!!)

    }

    override fun onMessageReceived(mensagemRemota:RemoteMessage?){
        if(mensagemRemota?.notification != null){
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
                Log.d(tag,"titulo: $titulo")
                Log.d(tag,"titulo:$corpo")
        }

    }

    private fun showNotification(mensagemRemota: RemoteMessage?){
        val intent = Intent(this,PedidosActivity::class.java)
        val titulo = mensagemRemota?.notification?.title
        val corpo = mensagemRemota?.notification?.body
        Notificationpush.create(1,intent,titulo!!,corpo!!)

    }

}