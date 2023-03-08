package com.akexorcist.coordinatorlayout.catalogue

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.coordinatorlayout.catalogue.data.Menu
import com.akexorcist.coordinatorlayout.catalogue.databinding.ActivityMainBinding
import com.akexorcist.coordinatorlayout.catalogue.list.MenuAdapter
import com.akexorcist.coordinatorlayout.category.fragment.FragmentContentActivity
import com.akexorcist.coordinatorlayout.category.shared.resource.ContentListActivity
import com.akexorcist.coordinatorlayout.category.shared.resource.ScrollableContentActivity

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter: MenuAdapter by lazy {
        MenuAdapter(this::onOpenMenuClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.update(createMenu())
    }

    private fun createMenu(): List<Menu> = listOf(
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.standard.R.string.title_standard),
            description = getString(com.akexorcist.coordinatorlayout.category.standard.R.string.description_standard),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.standard.R.layout.activity_standard,
            target = ScrollableContentActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.topsticky.R.string.title_top_sticky),
            description = getString(com.akexorcist.coordinatorlayout.category.topsticky.R.string.description_top_sticky),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.topsticky.R.layout.activity_top_sticky,
            target = ScrollableContentActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.snapped.R.string.title_snapped),
            description = getString(com.akexorcist.coordinatorlayout.category.snapped.R.string.description_snapped),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.snapped.R.layout.activity_snapped,
            target = ScrollableContentActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.stacked.R.string.title_stacked),
            description = getString(com.akexorcist.coordinatorlayout.category.stacked.R.string.description_stacked),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.stacked.R.layout.activity_stacked,
            target = ScrollableContentActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.recyclerview.R.string.title_recycler_view),
            description = getString(com.akexorcist.coordinatorlayout.category.recyclerview.R.string.description_recycler_view),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.recyclerview.R.layout.activity_recycler_view,
            target = ContentListActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.nestedchildview.R.string.title_nested_child_view),
            description = getString(com.akexorcist.coordinatorlayout.category.nestedchildview.R.string.description_nested_child_view),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.nestedchildview.R.layout.activity_nested_child_view,
            target = ContentListActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.fragment.R.string.title_fragment),
            description = getString(com.akexorcist.coordinatorlayout.category.fragment.R.string.description_fragment),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.fragment.R.layout.activity_fragment,
            target = FragmentContentActivity::class.java,
        ),
        Menu(
            title = getString(com.akexorcist.coordinatorlayout.category.motionlayout.R.string.title_motion_layout),
            description = getString(com.akexorcist.coordinatorlayout.category.motionlayout.R.string.description_motion_layout),
            layoutResourceId = com.akexorcist.coordinatorlayout.category.motionlayout.R.layout.activity_motion_layout,
            target = ScrollableContentActivity::class.java,
        ),
        Menu(
            title = getString(R.string.title_source_repository),
            description = getString(R.string.description_source_repository),
            layoutResourceId = 0,
            target = OpenGitHub::class.java,
        ),
    )

    private fun onOpenMenuClicked(menu: Menu) {
        val intent = when (menu.target) {
            ContentListActivity::class.java -> ContentListActivity.newIntent(
                context = this,
                layoutResourceId = menu.layoutResourceId,
                recyclerViewId = R.id.recyclerView,
            )
            FragmentContentActivity::class.java -> {
                FragmentContentActivity.newIntent(
                    context = this
                )
            }
            OpenGitHub::class.java -> {
                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://github.com/akexorcist/CoordinatorLayoutCatalogue")
                }
            }
            else -> ScrollableContentActivity.newIntent(
                context = this,
                layoutResourceId = menu.layoutResourceId,
            )
        }
        startActivity(intent)
    }
}
