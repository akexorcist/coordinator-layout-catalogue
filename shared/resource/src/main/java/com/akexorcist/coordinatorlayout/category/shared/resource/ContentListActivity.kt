package com.akexorcist.coordinatorlayout.category.shared.resource

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContentListActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_LAYOUT_RESOURCE_ID = "layout_resource_id"
        private const val EXTRA_RECYCLER_VIEW_ID = "recycler_view_id"

        fun newIntent(
            context: Context,
            @LayoutRes layoutResourceId: Int,
            @IdRes recyclerViewId: Int
        ) =
            Intent(context, ContentListActivity::class.java).apply {
                putExtra(EXTRA_LAYOUT_RESOURCE_ID, layoutResourceId)
                putExtra(EXTRA_RECYCLER_VIEW_ID, recyclerViewId)
            }
    }

    @get:LayoutRes
    private val layoutResourceId: Int
        get() = intent.getIntExtra(EXTRA_LAYOUT_RESOURCE_ID, 0)

    @get:IdRes
    private val recyclerViewId: Int
        get() = intent.getIntExtra(EXTRA_RECYCLER_VIEW_ID, 0)

    private val adapter: SampleListAdapter by lazy {
        SampleListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)

        val recyclerView = findViewById<RecyclerView>(recyclerViewId)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.update(
            items = (0 until 50).map { "Item $it" }
        )
    }
}
