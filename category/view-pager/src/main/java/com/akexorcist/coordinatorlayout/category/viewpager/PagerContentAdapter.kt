package com.akexorcist.coordinatorlayout.category.viewpager

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerContentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    private var pages: List<String> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun update(pages: List<String>) {
        this.pages = pages
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment = ContentFragment.newInstance(page = position)
}
