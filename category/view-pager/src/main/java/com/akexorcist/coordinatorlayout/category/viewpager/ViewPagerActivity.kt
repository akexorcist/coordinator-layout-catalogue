package com.akexorcist.coordinatorlayout.category.viewpager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.coordinatorlayout.category.viewpager.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context) = Intent(context, ViewPagerActivity::class.java)
    }

    private val binding: ActivityViewPagerBinding by lazy {
        ActivityViewPagerBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        PagerContentAdapter(supportFragmentManager, lifecycle)
    }

    private val pages = listOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = pages[position]
        }.attach()

        adapter.update(pages)
    }
}
