package com.notepad96.recyclerviewdivider

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.notepad96.recyclerviewdivider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler01.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAdapter()
            setHasFixedSize(true)
            // 1. 정의되어 있는 구분선
//            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            // 2. Custom 구분선
            addItemDecoration(CustomItemDecoration())

        }
    }
}