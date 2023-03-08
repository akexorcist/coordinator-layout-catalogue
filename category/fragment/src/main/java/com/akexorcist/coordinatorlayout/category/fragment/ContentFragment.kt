package com.akexorcist.coordinatorlayout.category.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akexorcist.coordinatorlayout.category.fragment.databinding.FragmentContentBinding

class ContentFragment : Fragment() {
    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var binding: FragmentContentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
