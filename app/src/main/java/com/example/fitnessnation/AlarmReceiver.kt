package com.example.fitnessnation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"HEREEE", Toast.LENGTH_LONG).show()
        val builder : NotificationCompat.Builder = NotificationCompat.Builder(context!!, "notify").setContentTitle("Alarm").setContentText("It's time for you to drink WATER!").setSmallIcon(R.drawable.ic_launcher_background)
        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())

    }
}