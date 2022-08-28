package com.notepad96.layoutexpandable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.notepad96.layoutexpandable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.layout01.setOnClickListener {
            if(binding.layoutDetail01.visibility == View.VISIBLE) {
                binding.layoutDetail01.visibility = View.GONE
                binding.layoutBtn01.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            } else {
                binding.layoutDetail01.visibility = View.VISIBLE
                binding.layoutBtn01.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        binding.layout02.setOnClickListener {
            if(binding.layoutDetail02.visibility == View.VISIBLE) {
                binding.layoutDetail02.visibility = View.GONE
                binding.layoutBtn02.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            } else {
                binding.layoutDetail02.visibility = View.VISIBLE
                binding.layoutBtn02.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

    }

}