package com.notepad96.refreshlayout

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.notepad96.refreshlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var count01 = 0
        var count02 = 0

        binding.button01.setOnClickListener {
            binding.textView01.text = "count01: ${--count01}"
            count02 -= 10
        }
        binding.button02.setOnClickListener {
            binding.textView01.text = "count01: ${++count01}"
            count02 += 10
        }

        binding.refreshLayout.setColorSchemeResources(R.color.purple_200, R.color.purple_500, R.color.teal_200)

        binding.refreshLayout.setOnRefreshListener {
            count01 = 0
            binding.textView01.text = "count01: $count01"
            binding.textView02.text = "count02: $count02"
            Toast.makeText(applicationContext, "Refresh Success", Toast.LENGTH_SHORT).show()

            binding.refreshLayout.isRefreshing = false
        }
    }
}