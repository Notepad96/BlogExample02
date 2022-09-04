package com.notepad96.recyclerviewstickyheader

import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.notepad96.recyclerviewstickyheader.databinding.ItemStickyBinding


class HeaderDecoration: RecyclerView.ItemDecoration() {
    lateinit var binding: ItemStickyBinding

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val topView = parent.getChildAt(0) ?: return
        val topViewPos = parent.getChildAdapterPosition(topView)
        if(topViewPos == RecyclerView.NO_POSITION) return



        c.save()
        c.translate(0f, 20f)
        binding.root.draw(c)
        c.restore()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        binding = ItemStickyBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(parent.getChildAdapterPosition(view) == 0) {
            binding.root.measure(View.MeasureSpec.makeMeasureSpec(parent.measuredWidth, View.MeasureSpec.AT_MOST)
            , View.MeasureSpec.makeMeasureSpec(parent.measuredHeight, View.MeasureSpec.AT_MOST))
            outRect.set(0, binding.root.measuredHeight, 0, 0)
        } else {
            outRect.setEmpty()
        }
    }
}