package com.harsh.roughdiamondrate.uiComponents.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.roughdiamondrate.databinding.ListOfRawCutHistoryBinding
import com.harsh.roughdiamondrate.databinding.ListOfTaiyarVeBinding
import com.harsh.roughdiamondrate.model.RawCutHistory
import com.harsh.roughdiamondrate.model.TaiyarVeList

class TaiyarVeListingAdapter(
    private var taiyarVeList: ArrayList<TaiyarVeList>,
    val context: Context
) : RecyclerView.Adapter<TaiyarVeListingAdapter.ViewHolder>() {

    inner class ViewHolder(val listOfTaiyarVeBinding: ListOfTaiyarVeBinding) :
        RecyclerView.ViewHolder(listOfTaiyarVeBinding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun search(list: ArrayList<TaiyarVeList>) {
        taiyarVeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListOfTaiyarVeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}