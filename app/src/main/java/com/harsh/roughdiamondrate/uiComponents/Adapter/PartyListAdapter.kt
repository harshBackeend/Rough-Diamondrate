package com.harsh.roughdiamondrate.uiComponents.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.roughdiamondrate.databinding.PartyListItemBinding
import com.harsh.roughdiamondrate.model.Data
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.uiComponents.activity.AddMoneyDetailActivity
import com.harsh.roughdiamondrate.uiComponents.activity.FilterActivity

class PartyListAdapter(val partyList: ArrayList<Data>, val context: Context) :
    RecyclerView.Adapter<PartyListAdapter.ViewHolder>() {

    inner class ViewHolder(val partyListItemBinding: PartyListItemBinding) :
        RecyclerView.ViewHolder(partyListItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PartyListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = partyList[position]

        holder.partyListItemBinding.textPartyName.text = model.partyName
        holder.partyListItemBinding.textPartyTotal.text = model.partyTotal

        holder.itemView.setOnClickListener {
            val intent = Intent(context, FilterActivity::class.java)
            intent.putExtra(IntentKey.partyName, model.partyName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = partyList.size
}