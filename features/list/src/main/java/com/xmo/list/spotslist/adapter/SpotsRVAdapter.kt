package com.xmo.list.spotslist.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xmo.list.R
import com.xmo.list.databinding.ItemSpotBinding
import com.xmo.list.spotslist.SpotsListFragmentDirections
import com.xmo.list.spotslist.model.SpotsItem

class SpotsRVAdapter : ListAdapter<SpotsItem, SpotsRVAdapter.SpotViewHolder>(Companion) {

    class SpotViewHolder(val binding: ItemSpotBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<SpotsItem>() {
        override fun areItemsTheSame(oldItem: SpotsItem, newItem: SpotsItem): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: SpotsItem, newItem: SpotsItem): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSpotBinding.inflate(layoutInflater)

        return SpotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpotViewHolder, position: Int) {

        val currentSpot = getItem(position)
        holder.binding.spot = currentSpot

        holder.binding.llItemWrapper.setOnClickListener {
            Log.d("xox", "clicked ID: ${currentSpot.id}")
            Navigation.findNavController(it).navigate(SpotsListFragmentDirections.actionSpotsListFragmentToSpotDetailsFragment(currentSpot.id))
        }

        holder.binding.executePendingBindings()
    }
}