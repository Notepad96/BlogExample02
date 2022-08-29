package com.notepad96.recyclerviewexpandable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.notepad96.recyclerviewexpandable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler01.apply {
            adapter = ListAdapter()
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}