package com.notepad96.recyclerviewduplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewduplication.databinding.ItemList01Binding
import com.notepad96.recyclerviewduplication.databinding.ItemList02Binding

class ListAdapter02(private val data: List<String>, private val parentPos: Int): RecyclerView.Adapter<ListAdapter02.MyView02>() {
    val images = listOf(R.drawable.bread, R.drawable.cat, R.drawable.cookie, R.drawable.dog)

    inner class MyView02(private val binding: ItemList02Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            binding.imageView01.setImageResource(images[parentPos])
            binding.textView02.text = data[pos]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView02 {
        val view = ItemList02Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView02(view)
    }

    override fun onBindViewHolder(holder: MyView02, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}