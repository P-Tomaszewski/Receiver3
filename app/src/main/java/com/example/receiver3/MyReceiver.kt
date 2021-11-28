package com.example.receiver3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

open class MyReceiver : BroadcastReceiver() {
    val requestCode = 1
    var id = 1
    override fun onReceive(context: Context, intent: Intent) {
      createNotificationChannel(context)
        //startService(Intent(context, MyService::class.java))

        val pendingIntent = PendingIntent.getActivity(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )
        val not = NotificationCompat.Builder(context, "12")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Dodano nowy produkt")
            .setContentText(intent.getStringExtra("name"))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(id++, not)
    }

    fun createNotificationChannel( context: Context){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return
        val notificationChannel = NotificationChannel(
            "12",
            "asd",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationChannel.description = "lok"

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.createNotificationChannel(notificationChannel)
    }
}