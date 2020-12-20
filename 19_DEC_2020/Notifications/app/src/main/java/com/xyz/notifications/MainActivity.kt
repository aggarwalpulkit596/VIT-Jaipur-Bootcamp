package com.xyz.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

const val CHANNEL_ID = "channel_123"
const val NOTIFICATION_ID = 100
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        button.setOnClickListener {
            createNotification()
        }

    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "my_channel"
            val description = "this is my channel for VIT app"
            val channel = NotificationChannel(CHANNEL_ID,name,NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = description

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }

    private fun createNotification(){

        val intent = Intent(this,MainActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
        notificationBuilder.setSmallIcon(R.drawable.ic_stat_alarm)
        notificationBuilder.setContentTitle("Hello there!")
        notificationBuilder.setContentText("It's time to wake up!")
        notificationBuilder.setPriority(NotificationCompat.PRIORITY_LOW)
        notificationBuilder.setContentIntent(pendingIntent)
        notificationBuilder.setAutoCancel(true)

        val notification = notificationBuilder.build()

        NotificationManagerCompat.from(this).notify(NOTIFICATION_ID,notification)

    }

}