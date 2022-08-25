package com.notepad96.recyclerviewmovetop

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewmovetop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView01.apply {
            adapter = ListAdapter()
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        val fadeIn = AlphaAnimation(0f, 1f).apply { duration = 500 }
        val fadeOut = AlphaAnimation(1f, 0f).apply { duration = 500 }
        var isTop = true

        binding.recyclerView01.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.recyclerView01.canScrollVertically(-1)
                    && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    binding.floatBtn01.startAnimation(fadeOut)
                    binding.floatBtn01.visibility = View.GONE
                    isTop = true
                    Log.d("myLog", "Top")
                } else {
                    if(isTop) {
                        binding.floatBtn01.visibility = View.VISIBLE
                        binding.floatBtn01.startAnimation(fadeIn)
                        isTop = false
                        Log.d("myLog", "Not Top")
                    }
                }
            }
        })

        binding.floatBtn01.setOnClickListener {
            binding.recyclerView01.smoothScrollToPosition(0)
        }
    }
}