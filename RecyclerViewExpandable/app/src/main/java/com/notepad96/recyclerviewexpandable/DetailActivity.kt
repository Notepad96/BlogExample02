package com.notepad96.recyclerviewexpandable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.notepad96.recyclerviewexpandable.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.detailText01.text = name
    }
}