package com.notepad96.recyclerviewswiperefresh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewswiperefresh.databinding.ItemListBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyView>() {
    var count = 5

    inner class MyView(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            binding.textTitle.text = "Title ${pos+1}"
            binding.textSubTitle.text = "Sub Title ${pos+1}"
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
        return count
    }

    fun addItem() {
        this.count++
    }

    fun removeItem() {
        if(this.count > 0) this.count--
    }
}