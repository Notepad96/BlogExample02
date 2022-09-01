package com.notepad96.recyclerviewduplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewduplication.databinding.ItemList01Binding

class ListAdapter01: RecyclerView.Adapter<ListAdapter01.MyView01>() {
    private val data = mapOf(
        "빵" to listOf("빵1", "빵2", "빵3"),
        "고양이" to listOf("고양이1", "고양이2", "고양이3", "고양이4"),
        "쿠키" to listOf("쿠키1", "쿠키2", "쿠키3", "쿠키4", "쿠키5"),
        "강아지" to listOf("강아지1", "강아지2", "강아지3", "강아지4", "강아지5")
    )

    inner class MyView01(private val binding: ItemList01Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            binding.textView01.text = data.keys.elementAt(pos)
            binding.recycler02.apply {
                adapter = ListAdapter02(data.values.elementAt(pos), pos)
                layoutManager = LinearLayoutManager(binding.recycler02.context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView01 {
        val view = ItemList01Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView01(view)
    }

    override fun onBindViewHolder(holder: MyView01, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}