package com.notepad96.alarmservice

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.notepad96.alarmservice.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object {
        const val REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val alarmManager = binding.root.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = Intent(binding.root.context, MyAlarmReceiver::class.java).let {
            it.putExtra("code", REQUEST_CODE)
            it.putExtra("count", 12)
            PendingIntent.getBroadcast(binding.root.context, REQUEST_CODE, it, 0)
        }

        binding.button01.setOnClickListener {
            // Case 1: 10초 후 10초 간격으로 Alarm (Min Interval: 1 minute)
//            alarmManager.setInexactRepeating(
//                AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 1000 * 10,
//                1000 * 10L,
//                pendingIntent
//            )

            // Case 2: 10초 후 2분 간격으로 Alarm (Min Interval: 1 minute)
//            alarmManager.setInexactRepeating(
//                AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 1000 * 10,
//                1000 * 60L * 2,
//                pendingIntent
//            )

            val alarmTime = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, 6)
                set(Calendar.MINUTE, 40)
            }
            alarmManager.setInexactRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                alarmTime.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )

            // 1회성 알림, 10초 후
//            alarmManager.set(
//                AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 1000 * 10,
//                pendingIntent
//            )
            Log.d("myLog", "Start")
        }

        binding.button02.setOnClickListener {
            alarmManager.cancel(pendingIntent)
            Log.d("myLog", "Cancel")
        }
    }
}