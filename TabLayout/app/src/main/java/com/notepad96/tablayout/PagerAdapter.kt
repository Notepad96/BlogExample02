package com.notepad96.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity, val count: Int): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment {
        return when(position) {

        }
    }
}