package com.xmo.list.spotslist.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.layoutManager

//        this.layoutManager.
       /* layoutManager. = JustifyContent.CENTER
        layoutManager. = AlignItems.CENTER
        layoutManager. = FlexDirection. ROW layoutManager.flexWrap = FlexWrap.WRAP
                my recycler.layout Manager = = layout Manager
       */


        this.adapter = adapter
    }
}