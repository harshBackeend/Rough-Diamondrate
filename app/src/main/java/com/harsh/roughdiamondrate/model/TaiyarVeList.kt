package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TaiyarVeList(

    @SerializedName("date") var date: String? = null,
    @SerializedName("no") var no: String? = null,
    @SerializedName("weight") var weight: String? = null,
    @SerializedName("veWeight") var veWeight: String? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("percentage") var percentage: String? = null,
    @SerializedName("payment") var payment: String? = null,
    @SerializedName("peroti") var peroti: String? = null,
    @SerializedName("partyName") var partyName: String? = null,
    @SerializedName("brokerName") var brokerName: String? = null,
    @SerializedName("numberOfDays") var numberOfDays: String? = null,
    @SerializedName("cvdDiamond") var cvdDiamond: String? = null,
    @SerializedName("brokerageInPercentage") var brokerageInPercentage: String? = null,
    @SerializedName("brokeragePrice") var brokeragePrice: String? = null,
    @SerializedName("finalPrice") var finalPrice: String? = null,
    @SerializedName("paymentDetail") var paymentDetail: String? = null,
    @SerializedName("detail") var detail: String? = null,
    @SerializedName("ok") var ok: String? = null,
    @SerializedName("rowId") var rowId: String? = null,
): Serializable