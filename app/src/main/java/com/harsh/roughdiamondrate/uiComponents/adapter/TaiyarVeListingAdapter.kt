package com.harsh.roughdiamondrate.uiComponents.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ListOfTaiyarVeBinding
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.model.TaiyarVeList
import com.harsh.roughdiamondrate.uiComponents.activity.RawCutDetailActivity
import com.harsh.roughdiamondrate.uiComponents.activity.TaiyarVeEnteryActivity

class TaiyarVeListingAdapter(
    private var taiyarVeList: ArrayList<TaiyarVeList>,
    val context: Context
) : RecyclerView.Adapter<TaiyarVeListingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListOfTaiyarVeBinding) :
        RecyclerView.ViewHolder(binding.root)

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

    override fun getItemCount(): Int= taiyarVeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = taiyarVeList[position]

        holder.binding.textDate.text = model.date
        holder.binding.textNo.text = model.no
        holder.binding.textWeight.text = model.weight
        holder.binding.textVeWeight.text = model.veWeight
        holder.binding.textPrice.text = model.price
        holder.binding.textPercentage.text = model.percentage
        holder.binding.textPayment.text = model.payment
        holder.binding.textPeroti.text = model.peroti
        holder.binding.textPartyName.text = model.partyName
        holder.binding.textBrokerName.text = model.brokerName
        holder.binding.textDays.text = model.numberOfDays
        holder.binding.textCVD.text = model.cvdDiamond
        holder.binding.textBrokerPercentage.text = model.brokerageInPercentage
        holder.binding.textBrokerage.text = model.brokeragePrice
        holder.binding.textAfterBrokerage.text = model.finalPrice
        holder.binding.textPaymentDetail.text = model.paymentDetail
        holder.binding.textDetail.text = model.detail
        holder.binding.textOk.text = model.ok

        holder.itemView.setOnClickListener {
            val intent = Intent(context, TaiyarVeEnteryActivity::class.java)
            intent.putExtra(IntentKey.taiyarDetail,model)
            intent.putExtra(IntentKey.rowId,model.rowId)
            context.startActivity(intent)
        }
    }
}