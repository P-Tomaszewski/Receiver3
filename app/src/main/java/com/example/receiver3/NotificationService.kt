package com.example.receiver3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.core.app.NotificationManagerCompat

class NotificationService(base: Context?) : ContextWrapper(base) {

        fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return
        val notificationChannel = NotificationChannel(
            "12",
            "asd",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationChannel.description = "lok"

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.createNotificationChannel(notificationChannel)
    }
}