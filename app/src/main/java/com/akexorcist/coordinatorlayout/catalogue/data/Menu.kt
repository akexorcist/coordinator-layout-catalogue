package com.akexorcist.coordinatorlayout.catalogue.data

import androidx.annotation.LayoutRes

data class Menu(
    val title: String,
    val description: String,
    @LayoutRes val layoutResourceId: Int,
    val target: Class<*>,
)
