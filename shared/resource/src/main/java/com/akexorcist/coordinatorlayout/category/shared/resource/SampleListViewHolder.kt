package com.akexorcist.coordinatorlayout.category.shared.resource

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.coordinatorlayout.category.shared.resource.databinding.ViewSampleListBinding

class SampleListViewHolder(private val binding: ViewSampleListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.tvItem.text = text
    }
}
