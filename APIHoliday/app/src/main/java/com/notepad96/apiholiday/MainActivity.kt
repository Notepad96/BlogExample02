package com.notepad96.apiholiday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.notepad96.apiholiday.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var holidayList = listOf<MyDateItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            loadList()
        }
    }

    private fun loadList() {
        val call = HolidayObject.getRetrofitService.getHoliday()
        call.enqueue(object: Callback<List<MyDateItem>> {
            override fun onResponse(call: Call<List<MyDateItem>>, response: Response<List<MyDateItem>>) {
                Toast.makeText(applicationContext, "Call Success", Toast.LENGTH_SHORT).show()
                if(response.isSuccessful) {
                    holidayList = response.body() ?: listOf()
                    holidayList.forEach {
                        Log.d("myLog", it.toString())
                    }
                }
            }
            override fun onFailure(call: Call<List<MyDateItem>>, t: Throwable) {
                Toast.makeText(applicationContext, "Call Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}