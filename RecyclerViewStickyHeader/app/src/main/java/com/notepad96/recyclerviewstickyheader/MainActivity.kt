package com.notepad96.recyclerviewstickyheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.notepad96.recyclerviewstickyheader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView01.apply {
            adapter = RecyclerAdapter()
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

    }
}