package com.akexorcist.coordinatorlayout.category.shared.resource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.coordinatorlayout.category.shared.resource.databinding.ViewSampleListBinding

class SampleListAdapter : RecyclerView.Adapter<SampleListViewHolder>() {
    private var items: List<String> = listOf()

    fun update(items: List<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleListViewHolder {
        val view = ViewSampleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SampleListViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SampleListViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
