package com.akexorcist.coordinatorlayout.category.shared.resource

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

class ScrollableContentActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_LAYOUT_RESOURCE_ID = "layout_resource_id"

        fun newIntent(context: Context, @LayoutRes layoutResourceId: Int) =
            Intent(context, ScrollableContentActivity::class.java).apply {
                putExtra(EXTRA_LAYOUT_RESOURCE_ID, layoutResourceId)
            }
    }

    @get:LayoutRes
    private val layoutResourceId: Int
        get() = intent.getIntExtra(EXTRA_LAYOUT_RESOURCE_ID, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
    }
}