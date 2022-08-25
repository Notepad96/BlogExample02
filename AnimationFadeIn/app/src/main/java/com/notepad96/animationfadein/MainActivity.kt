package com.notepad96.animationfadein

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.notepad96.animationfadein.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val anim1 = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 3000
        }

        binding.button01.setOnClickListener {
            binding.button02.visibility = View.VISIBLE
            binding.button02.startAnimation(anim1)
        }

        val fadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        val scaleOut = AnimationUtils.loadAnimation(applicationContext, R.anim.scale_out)
        val moveRight = AnimationUtils.loadAnimation(applicationContext, R.anim.move_right)

        binding.button02.setOnClickListener {
            binding.floatBtn01.visibility = View.VISIBLE
            binding.floatBtn01.startAnimation(fadeIn)
        }

        binding.floatBtn01.setOnClickListener {
            binding.floatBtn02.visibility = View.VISIBLE
            binding.floatBtn02.startAnimation(scaleOut)
        }

        binding.floatBtn02.setOnClickListener {
            binding.floatBtn03.visibility = View.VISIBLE
            binding.floatBtn03.startAnimation(moveRight)
        }
    }
}