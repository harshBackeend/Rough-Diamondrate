package com.harsh.roughdiamondrate.uiComponents.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ListOfRawCutHistoryBinding
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.model.RawCutHistory
import com.harsh.roughdiamondrate.uiComponents.activity.RawCutDetailActivity

class RawCutHistoryAdapter(
    private var rawCutHistoryList: ArrayList<RawCutHistory>,
    val context: Context
) : RecyclerView.Adapter<RawCutHistoryAdapter.ViewHolder>() {

    inner class ViewHolder(val listOfRawCutHistoryBinding: ListOfRawCutHistoryBinding) :
        RecyclerView.ViewHolder(listOfRawCutHistoryBinding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun search(list: ArrayList<RawCutHistory>) {
        rawCutHistoryList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListOfRawCutHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = rawCutHistoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = rawCutHistoryList[position]

        holder.listOfRawCutHistoryBinding.dateText.text = model.date
        holder.listOfRawCutHistoryBinding.mainKatNumber.text = model.mainKatNumber
        holder.listOfRawCutHistoryBinding.katName.text = model.katName
        holder.listOfRawCutHistoryBinding.maineWeight.text = model.maineWeight
        holder.listOfRawCutHistoryBinding.bag.text = model.bag
        holder.listOfRawCutHistoryBinding.weight.text = model.weight
        holder.listOfRawCutHistoryBinding.price.text = model.price
        holder.listOfRawCutHistoryBinding.dollarPrice.text = model.dollarPrice
        holder.listOfRawCutHistoryBinding.brokeragePrice.text = model.brokeragePrice
        holder.listOfRawCutHistoryBinding.sellingPrice.text = model.sellingPrice
        holder.listOfRawCutHistoryBinding.totalPrice.text = model.totalPrice
        holder.listOfRawCutHistoryBinding.textFinalPrice.text = model.finalPrice
        holder.listOfRawCutHistoryBinding.textPartyName.text = model.partyName
        holder.listOfRawCutHistoryBinding.textBrokerName.text = model.brokerName
        holder.listOfRawCutHistoryBinding.textDays.text = model.numberOfDays
        holder.listOfRawCutHistoryBinding.textDetail.text = model.detail
        holder.listOfRawCutHistoryBinding.textOk.text = model.fianlOk
        holder.listOfRawCutHistoryBinding.numberWeight.text = model.numberWeight
        holder.listOfRawCutHistoryBinding.numberPrice.text = model.numberPrice
        holder.listOfRawCutHistoryBinding.numberPercentage.text = model.numberPercentage
        holder.listOfRawCutHistoryBinding.numberTotalPrice.text = model.numberTotalPrice
        holder.listOfRawCutHistoryBinding.textNumberPartyName.text = model.numberPartyName
        holder.listOfRawCutHistoryBinding.textNumberBrokerName.text = model.numberBrokerName
        holder.listOfRawCutHistoryBinding.textNumberOk.text = model.numberOk
        holder.listOfRawCutHistoryBinding.textNumberDetail.text = model.numberDetail
        Utility.printLog("rouId","${model.rowId}")

        holder.itemView.setOnClickListener {
            val intent = Intent(context, RawCutDetailActivity::class.java)
            intent.putExtra(IntentKey.rawCutDetail,model)
            intent.putExtra(IntentKey.rowId,model.rowId)
            context.startActivity(intent)
        }

    }

}