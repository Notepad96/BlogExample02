package com.notepad96.alarmnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyAlarmReceiver: BroadcastReceiver() {
    val CHANNEL_ID = "Test"
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.extras?.get("code") == MainActivity.REQUEST_CODE) {
            var count = intent.getIntExtra("count", 0)
            Log.d("myLog", "$count")

            MainActivity.view.instance.appendLog("Alarm Check $count")


            createNotificationChannel(context)

            val intent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent = PendingIntent.getActivity(context, 101, intent, 0)

            val contents = "Contents Contents Contents Contents Contents Contents Contents " +
                    "Contents Contents Contents Contents Contents Contents Contents "

            // Notification
            var builder01 = NotificationCompat.Builder(context, CHANNEL_ID).apply {
                setSmallIcon(R.drawable.ic_baseline_apple_24)
                setContentTitle("Title 1")  // Set Title
                setContentText(contents)   // Set Content
                priority = NotificationCompat.PRIORITY_DEFAULT  // Set PRIORITY
                setContentIntent(pendingIntent) // Notification Click Event
                setAutoCancel(true) // Remove After Click Notification
            }

            with(NotificationManagerCompat.from(context)) {
                notify(5, builder01.build())
            }
        }
    }

    private fun createNotificationChannel(context: Context?) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification_Ch"
            val descriptionText = "Test Notification"
            val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = descriptionText
            }

            val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
