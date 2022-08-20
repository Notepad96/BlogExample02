package com.notepad96.tablayoutcustomstyle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.notepad96.tablayoutcustomstyle.databinding.FragmentPage02Binding

class Page02 : Fragment() {
    lateinit var binding: FragmentPage02Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage02Binding.inflate(inflater, container, false)

        return binding.root
    }

}