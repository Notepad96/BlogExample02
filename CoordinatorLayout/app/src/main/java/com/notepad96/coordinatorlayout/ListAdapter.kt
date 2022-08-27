package com.notepad96.coordinatorlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.coordinatorlayout.databinding.ItemListBinding
import java.text.DecimalFormat

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyView>() {

    inner class MyView(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.mainText.text = "Menu $position"
            val price = DecimalFormat("#,###")
            binding.subText.text = "${price.format(position * 10000)} WON"
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