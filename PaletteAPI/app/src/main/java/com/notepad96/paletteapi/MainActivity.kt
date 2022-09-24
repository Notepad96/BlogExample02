package com.notepad96.paletteapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.notepad96.paletteapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        
    }
}