package com.akexorcist.coordinatorlayout.catalogue.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.coordinatorlayout.catalogue.data.Menu
import com.akexorcist.coordinatorlayout.catalogue.databinding.ViewMenuItemBinding

class MenuAdapter(private val onOpenClicked: (Menu) -> Unit) : RecyclerView.Adapter<MenuItemViewHolder>() {
    private var menus: List<Menu> = listOf()

    fun update(menus: List<Menu>) {
        this.menus = menus
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val view = ViewMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuItemViewHolder(view)
    }

    override fun getItemCount(): Int = menus.count()

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(menus[position]) {
            onOpenClicked.invoke(it)
        }
    }
}
