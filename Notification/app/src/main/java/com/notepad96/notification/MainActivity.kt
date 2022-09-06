package com.notepad96.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.notepad96.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object {
        const val CHANNEL_ID = "Test"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        createNotificationChannel()

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 101, intent, 0)

        val contents = "Contents Contents Contents Contents Contents Contents Contents " +
                "Contents Contents Contents Contents Contents Contents Contents "

        var builder01 = NotificationCompat.Builder(this, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_baseline_alarm_24)   // Set Icon
            setContentTitle("Title 1")  // Set Title
            setContentText(contents)   // Set Content
            priority = NotificationCompat.PRIORITY_DEFAULT  // Set PRIORITY
            setContentIntent(pendingIntent) // Notification Click Event
            setAutoCancel(true) // Remove After Click Notification
        }

        var builder02 = NotificationCompat.Builder(this, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_baseline_alarm_24)
            setContentTitle("Title 2")
            setContentText(contents)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.bread))
            setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.bread))
                .bigLargeIcon(null)
                .setBigContentTitle("확장")
            )
            setContentIntent(pendingIntent)
//            setAutoCancel(true)
        }

        binding.button01.setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                notify(5, builder01.build())
            }
        }

        binding.button02.setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                notify(6, builder02.build())
            }
        }
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification_Ch"
            val descriptionText = "Test Notification"
            val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = descriptionText
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}