package com.notepad96.recyclerviewstickyheader

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyView>(){

    inner class MyView(val binding: View): RecyclerView.ViewHolder(binding.rootView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return 30
    }
}