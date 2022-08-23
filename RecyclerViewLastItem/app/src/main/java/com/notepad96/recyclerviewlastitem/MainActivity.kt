package com.notepad96.recyclerviewlastitem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewlastitem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView01.apply {
            adapter = RecyclerAdapter()
            layoutManager = LinearLayoutManager(context)
        }

        var count = 0
        binding.recyclerView01.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!binding.recyclerView01.canScrollVertically(1)
                    && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Toast.makeText(applicationContext, "Last Item (${count++})", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}