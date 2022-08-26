package com.notepad96.recyclerviewstickyheader

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class HeaderDecoration(private val headerView: View): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val topView = parent.getChildAt(0) ?: return
        val topPosition = parent.getChildAdapterPosition(topView)

        c.save()
        c.translate(0f, 0f)
        headerView.draw(c)
        c.restore()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if(parent.getChildAdapterPosition(view) == 0) {
            headerView.measure(View.MeasureSpec.makeMeasureSpec(parent.measuredWidth, View.MeasureSpec.AT_MOST)
            , View.MeasureSpec.makeMeasureSpec(parent.measuredHeight, View.MeasureSpec.AT_MOST))
            outRect.set(0, headerView.measuredHeight, 0, 0)
        } else {
            outRect.setEmpty()
        }
    }
}