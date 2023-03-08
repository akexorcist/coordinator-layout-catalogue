package com.akexorcist.coordinatorlayout.catalogue.list

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.coordinatorlayout.catalogue.data.Menu
import com.akexorcist.coordinatorlayout.catalogue.databinding.ViewMenuItemBinding

class MenuItemViewHolder(private val binding: ViewMenuItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(menu: Menu, onOpenClicked: (Menu) -> Unit) {
        binding.tvTitle.text = menu.title
        binding.tvDescription.text = menu.description
        binding.btnOpen.setOnClickListener { onOpenClicked(menu) }
    }
}
