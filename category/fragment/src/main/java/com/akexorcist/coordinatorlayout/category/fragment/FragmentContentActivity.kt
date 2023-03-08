package com.akexorcist.coordinatorlayout.category.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.akexorcist.coordinatorlayout.category.fragment.databinding.ActivityFragmentBinding

class FragmentContentActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context) = Intent(context, FragmentContentActivity::class.java)
    }

    private val binding: ActivityFragmentBinding by lazy {
        ActivityFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(binding.fragmentContainerView.id, ContentFragment.newInstance())
            }
        }
    }
}
