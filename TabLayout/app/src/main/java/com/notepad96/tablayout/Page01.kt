package com.notepad96.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.notepad96.tablayout.databinding.FragmentPage01Binding

class Page01 : Fragment() {
    lateinit var binding: FragmentPage01Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage01Binding.inflate(inflater, container, false)

        return binding.root
    }

}