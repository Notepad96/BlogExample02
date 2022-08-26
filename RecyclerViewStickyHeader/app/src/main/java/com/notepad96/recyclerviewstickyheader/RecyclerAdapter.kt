package com.notepad96.recyclerviewstickyheader

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.notepad96.recyclerviewstickyheader.databinding.ItemListBinding
import com.notepad96.recyclerviewstickyheader.databinding.ItemStickyBinding


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyView>(){
    companion object {
        const val VIEW_HEADER = 0
        const val VIEW_ITEM = 1
        val NAMES = listOf("Kim", "Lee", "Koo")
    }

    inner class MyView(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            (binding as ItemListBinding).mainText.text = NAMES[position % 3]
            binding.subText.text = "${position * position}"

            binding.mainText.setOnClickListener {
                Log.d("myLog", "$position")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0) VIEW_HEADER else VIEW_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = when(viewType) {
            VIEW_HEADER -> ItemStickyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            else -> ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        if(position != 0) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return 40
    }


}