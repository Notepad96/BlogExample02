package com.notepad96.floatinganimation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.notepad96.floatinganimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var isOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val floatBtn02AniOut = ObjectAnimator.ofFloat(binding.floating02, "translationX", -200f).setDuration(500)
        val floatBtn02AniIn = ObjectAnimator.ofFloat(binding.floating02, "translationX", 0f).setDuration(500)
        val floatBtn04AniOut = ObjectAnimator.ofFloat(binding.floating04, "translationY", -200f).setDuration(500)
        val floatBtn04AniIn = ObjectAnimator.ofFloat(binding.floating04, "translationY", 0f).setDuration(500)

        val txOut = PropertyValuesHolder.ofFloat("translationX", -150f)
        val tyOut = PropertyValuesHolder.ofFloat("translationY", -150f)
        val floatBtn03AniOut = ObjectAnimator.ofPropertyValuesHolder(binding.floating03, txOut, tyOut).setDuration(500)

        val txIn = PropertyValuesHolder.ofFloat("translationX", 0f)
        val tyIn = PropertyValuesHolder.ofFloat("translationY", 0f)
        val floatBtn03AniIn = ObjectAnimator.ofPropertyValuesHolder(binding.floating03, txIn, tyIn).setDuration(500)


        binding.floating01.setOnClickListener {
            if(isOpened) {
                binding.floating01.setImageResource(R.drawable.ic_baseline_add_24)
                floatBtn02AniIn.start()
                floatBtn03AniIn.start()
                floatBtn04AniIn.start()
            } else {
                binding.floating01.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                floatBtn02AniOut.start()
                floatBtn03AniOut.start()
                floatBtn04AniOut.start()
            }
            isOpened = !isOpened
        }

        binding.floating02.setOnClickListener { Toast.makeText(applicationContext, "Click 2!", Toast.LENGTH_SHORT).show() }
        binding.floating03.setOnClickListener { Toast.makeText(applicationContext, "Click 3!", Toast.LENGTH_SHORT).show() }
        binding.floating04.setOnClickListener { Toast.makeText(applicationContext, "Click 4!", Toast.LENGTH_SHORT).show() }
    }
}