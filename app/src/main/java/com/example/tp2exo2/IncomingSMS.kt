package com.example.tp2exo2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService

class IncomingSMS : BroadcastReceiver() {
    private val channelId = "03"
    private val channelName = "Email Channel"
    private val importance = NotificationManager.IMPORTANCE_HIGH
     override fun onReceive(context: Context, intent: Intent) {
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    for (sms : SmsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent))
                    {
                       Toast.makeText(context, sms.displayMessageBody,Toast.LENGTH_LONG).show()

//                        val pIntent = PendingIntent.getActivity(context, System.currentTimeMillis().toInt(), intent, 0)
//                        val notifManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                        val mChannel = NotificationChannel(
//                            channelId, channelName, importance)
//                        notifManager.createNotificationChannel(mChannel)
//                        val noti = Notification.Builder(context,"ch23")
//                            .setContentTitle("Text Received")
//                            .setContentText(sms.displayMessageBody).setSmallIcon(android.R.drawable.btn_star)
//                            .setContentIntent(pIntent).setAutoCancel(true)
//
//                            .build()
//                        notifManager.notify(0, noti)}
//                        else{
//
//                            val noti = Notification.Builder(context)
//                                .setContentTitle("Text Received")
//                                .setContentText(sms.displayMessageBody).setSmallIcon(android.R.drawable.btn_star)
//                                .setContentIntent(pIntent).setAutoCancel(true)
//
//                                .build()
//                            notifManager.notify(0, noti)
//
//                        }

                        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            val mChannel = NotificationChannel(
                                channelId, channelName, importance)
                            notificationManager.createNotificationChannel(mChannel)
                        }

                        val noti = Notification.Builder(context, channelId)
                            .setContentTitle("Text Received")
                            .setContentText(sms.displayOriginatingAddress)
                            .setSmallIcon(android.R.drawable.btn_dialog)
                            .setAutoCancel(true)
                            .build()
                        notificationManager.notify(0, noti)
                    }



                    }
                }
      }
   // }
