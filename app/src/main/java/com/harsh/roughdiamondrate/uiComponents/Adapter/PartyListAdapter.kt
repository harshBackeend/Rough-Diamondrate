package com.harsh.roughdiamondrate.uiComponents.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.harsh.roughdiamondrate.databinding.PartyListItemBinding
import com.harsh.roughdiamondrate.model.Data

class PartyListAdapter(val partyList: ArrayList<Data>, val context: Context) :
    RecyclerView.Adapter<PartyListAdapter.ViewHolder>() {

    inner class ViewHolder(val partyListItemBinding: PartyListItemBinding) :
        RecyclerView.ViewHolder(partyListItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PartyListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = partyList.size
}