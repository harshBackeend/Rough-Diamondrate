package com.harsh.roughdiamondrate.uiComponents.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.roughdiamondrate.databinding.ListOfHistoryLayoutBinding
import com.harsh.roughdiamondrate.model.Data

class HistoryAdapter(private val list:ArrayList<Data>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(internal val binding: ListOfHistoryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListOfHistoryLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.binding.dateText.text = model.date
        holder.binding.partyName.text = model.partyName
        holder.binding.depositText.text = model.deposit
        holder.binding.depositNumberText.text = model.depositNo
        holder.binding.creditText.text = model.credit
        holder.binding.creditNumberText.text = model.creditNo
        holder.binding.detailText.text = model.detail
    }

    override fun getItemCount(): Int = list.size
}