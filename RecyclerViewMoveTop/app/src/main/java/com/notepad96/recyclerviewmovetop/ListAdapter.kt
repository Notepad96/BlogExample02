package com.notepad96.recyclerviewmovetop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewmovetop.databinding.ItemListBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyView>() {
    inner class MyView(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            binding.mainText.text = "$pos"
            binding.mainText.text = "${pos * pos}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 40
    }
}