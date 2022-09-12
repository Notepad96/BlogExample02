package com.notepad96.recyclerviewswiperefresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.notepad96.recyclerviewswiperefresh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listAdapter = ListAdapter()

        binding.recyclerview01.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        binding.refreshLayout01.setOnRefreshListener {
            listAdapter.notifyDataSetChanged()
            Toast.makeText(applicationContext, "List Refresh", Toast.LENGTH_SHORT).show()
            binding.refreshLayout01.isRefreshing = false
        }

        binding.btnAdd.setOnClickListener {
            Toast.makeText(applicationContext, "Add Item", Toast.LENGTH_SHORT).show()
            listAdapter.addItem()
            listAdapter.notifyItemInserted()
        }
        binding.btnRemove.setOnClickListener {
            Toast.makeText(applicationContext, "Remove Item", Toast.LENGTH_SHORT).show()
            listAdapter.removeItem()
        }
    }
}