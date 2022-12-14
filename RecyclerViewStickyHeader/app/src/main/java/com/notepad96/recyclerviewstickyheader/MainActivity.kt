package com.notepad96.recyclerviewstickyheader

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewstickyheader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView01.apply {
            adapter = RecyclerAdapter()
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = true
            setHasFixedSize(true)
        }

        binding.recyclerView01.addItemDecoration(HeaderDecoration())

//        binding.recyclerView01.addOnScrollListener(object: RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                val view = recyclerView.getChildAt(0)
//                recyclerView.onChildAttachedToWindow(view)
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
////                val pos = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
//                val pos = (binding.recyclerView01.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
//
//            }
//        })

    }
}
