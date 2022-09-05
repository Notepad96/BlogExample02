package com.notepad96.alarmservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyAlarmReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1?.extras?.get("code") == MainActivity.REQUEST_CODE) {
            var count = p1.getIntExtra("count", 0)
            Log.d("myLog", "$count")
        }
    }
}