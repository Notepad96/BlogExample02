package com.notepad96.animationfadein

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.notepad96.animationfadein.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fadeIn01 = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 3000
        }
        val scaleOut01 = ScaleAnimation(0f, 2f, 0f, 2f, .5f, .5f).apply {
            duration = 2000
        }
        val moveRight01 = TranslateAnimation(0f, 300f, 0f, 0f).apply {
            duration = 2000
        }


        binding.button01.setOnClickListener {
            binding.button01.startAnimation(fadeIn01)
        }
        binding.button02.setOnClickListener {
            binding.button02.startAnimation(scaleOut01)
        }
        binding.button03.setOnClickListener {
            binding.button03.startAnimation(moveRight01)
        }


        val fadeIn02 = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        val scaleOut02 = AnimationUtils.loadAnimation(applicationContext, R.anim.scale_out)
        val moveRight02 = AnimationUtils.loadAnimation(applicationContext, R.anim.move_right)

        binding.floatBtn01.setOnClickListener {
            binding.floatBtn01.startAnimation(fadeIn02)
        }

        binding.floatBtn02.setOnClickListener {
            binding.floatBtn02.startAnimation(scaleOut02)
        }

        binding.floatBtn03.setOnClickListener {
            binding.floatBtn03.startAnimation(moveRight02)
        }
    }
}