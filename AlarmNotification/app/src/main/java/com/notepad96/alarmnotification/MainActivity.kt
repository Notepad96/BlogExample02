package com.notepad96.alarmnotification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.notepad96.alarmnotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var setting: SharedPreferences

    companion object {
        const val REQUEST_CODE = 101
    }
    object view {
        lateinit var instance: MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        view.instance = this
        setting = getSharedPreferences("setting", MODE_PRIVATE)
        binding.switch01.isChecked = setting.getBoolean("alarm", false)

        val alarmManager = binding.root.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = Intent(binding.root.context, MyAlarmReceiver::class.java).let {
            it.putExtra("code", REQUEST_CODE)
            it.putExtra("count", 10)
            PendingIntent.getBroadcast(binding.root.context, REQUEST_CODE, it, 0)
        }

        binding.switch01.setOnCheckedChangeListener { _, isCheck ->
            setting.edit {
                putBoolean("alarm", isCheck)
            }
            if(isCheck) {
                alarmManager.set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + 1000 * 10,
                    pendingIntent
                )
                appendLog("Alarm Start")
            } else {
                alarmManager.cancel(pendingIntent)
                appendLog("Alarm Cancel")
            }
        }
    }

    fun appendLog(str: String) {
        binding.logText.text = "${binding.logText.text}\n${str}"
    }
}