package com.akexorcist.coordinatorlayout.category.viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.coordinatorlayout.category.viewpager.databinding.FragmentViewPagerContentBinding
import com.akexorcist.coordinatorlayout.category.viewpager.databinding.ViewPagerContentBinding

class ContentFragment : Fragment() {
    companion object {
        private const val EXTRA_PAGE = "page"

        fun newInstance(page: Int) = ContentFragment().apply {
            arguments = Bundle().apply {
                putInt(EXTRA_PAGE, page)
            }
        }
    }

    private lateinit var binding: FragmentViewPagerContentBinding

    private val adapter by lazy { ContentAdapter(count = 20) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentViewPagerContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }
}

private class ContentAdapter(private val count: Int) : RecyclerView.Adapter<ContentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder =
        ContentViewHolder(ViewPagerContentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = count

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(position)
    }
}

private class ContentViewHolder(private val binding: ViewPagerContentBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(position: Int) {
        binding.textView.text = "Item $position"
    }
}
