package com.example.tp2exo2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.*
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECEIVE_SMS),111)
        }
        notif.setOnClickListener {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val mChannel = NotificationChannel(
                    "2303", "example", NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(mChannel)
            }

            val noti = Notification.Builder(this, "2303")
                .setContentTitle("Notification")
                .setContentText("Je viens de recevioir une notification !")
                .setSmallIcon(android.R.drawable.btn_dialog)
                .setAutoCancel(true)
                .build()
            notificationManager.notify(0, noti)
        }
    }




}
