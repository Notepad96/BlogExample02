package com.notepad96.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.notepad96.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.Btn01.setOnClickListener {
            binding.Text01.text = "Change Text"
        }
    }
}