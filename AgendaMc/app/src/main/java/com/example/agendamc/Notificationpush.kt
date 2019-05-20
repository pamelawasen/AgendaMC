package com.example.agendamc

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import com.example.agendamc.Activity.AgendaAplication
import com.example.agendamc.Activity.PedidosActivity
import com.example.agendamc.Activity.PedidosList

object Notificationpush {

    internal val channel_id= "1"

    fun createchannel() {
            if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
                val contexto = AgendaAplication.getInstance().applicationContext
                val manager = contexto
                    .getSystemService(Context.NOTIFICATION_SERVICE)
                        as NotificationManager

                val appName = contexto.getString(R.string.app_name)
                val c = NotificationChannel(channel_id, appName, NotificationManager.IMPORTANCE_HIGH)
                manager.createNotificationChannel(c)
            }
        }

        fun create(id:Int,intent: Intent,titulo:String,texto:String){
            createchannel()
            val context = AgendaAplication.getInstance().applicationContext
            val p = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            val builder = NotificationCompat.Builder(context,channel_id)
                .setContentIntent(p)
                .setContentTitle(titulo)
                .setContentText(texto)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

            with(NotificationManagerCompat.from(AgendaAplication.getInstance())){
                val n = builder.build()
                notify(id, n)
            }
        }

    }
