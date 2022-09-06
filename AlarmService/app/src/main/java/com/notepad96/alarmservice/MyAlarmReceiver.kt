package com.notepad96.alarmservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyAlarmReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1?.extras?.get("code") == MainActivity.REQUEST_CODE) {
            Toast.makeText(p0, "Alarm Start", Toast.LENGTH_SHORT).show()
            var count = p1.getIntExtra("count", 0)
            Log.d("myLog", "$count")
        }
    }
}