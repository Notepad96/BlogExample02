package com.notepad96.alarmservice

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.notepad96.alarmservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var setting: SharedPreferences

    companion object {
        const val REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setting = getSharedPreferences("setting", MODE_PRIVATE)
        binding.toggleButton01.isChecked = setting.getBoolean("alarm", false)

        val alarmManager = binding.root.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = Intent(binding.root.context, MyAlarmReceiver::class.java).let {
            it.putExtra("code", REQUEST_CODE)
            it.putExtra("count", 32)
            PendingIntent.getBroadcast(binding.root.context, REQUEST_CODE, it, 0)
        }

        binding.toggleButton01.setOnCheckedChangeListener { _, b ->
            setting.edit {
                putBoolean("alarm", b)
            }

            if(b) {
                // Case 0: 1회성 알람, 10초 후
                alarmManager.set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + 1000 * 10,
                    pendingIntent
                )

                // Case 1: 10초 후 10초 간격으로 Alarm (Min Interval: 1 minute)
//            alarmManager.setInexactRepeating(
//                AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 1000 * 10,
//                1000 * 10L,
//                pendingIntent
//            )

                // Case 2: 10초 후 2분 간격으로 Alarm (Interval: 2 minute)
//            alarmManager.setInexactRepeating(
//                AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 1000 * 10,
//                1000 * 60L * 2,
//                pendingIntent
//            )

                // Case 3: 오전 8시 27분 Alarm 생성 (Interval: Day)
//                val calendar = Calendar.getInstance().apply {
//                    timeInMillis = System.currentTimeMillis()
//                    set(Calendar.HOUR_OF_DAY, 8)
//                    set(Calendar.MINUTE, 27)
//                }
//                alarmManager.setInexactRepeating(
//                    AlarmManager.RTC_WAKEUP,
//                    calendar.timeInMillis,
//                    AlarmManager.INTERVAL_DAY,
//                    pendingIntent
//                )
                Toast.makeText(applicationContext, "Start", Toast.LENGTH_SHORT).show()
                Log.d("myLog", "Start")
            } else {
                alarmManager.cancel(pendingIntent)
                Toast.makeText(applicationContext, "Cancel", Toast.LENGTH_SHORT).show()
                Log.d("myLog", "Cancel")
            }
        }
    }
}