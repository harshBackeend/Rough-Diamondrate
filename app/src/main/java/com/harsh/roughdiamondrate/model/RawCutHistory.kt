package com.harsh.roughdiamondrate.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class RawCutHistory(

    @SerializedName("date") var date: String? = null,
    @SerializedName("mainKatNumber") var mainKatNumber: String? = null,
    @SerializedName("katName") var katName: String? = null,
    @SerializedName("maineWeight") var maineWeight: String? = null,
    @SerializedName("bag") var bag: String? = null,
    @SerializedName("weight") var weight: String? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("dollarPrice") var dollarPrice: String? = null,
    @SerializedName("brokeragePrice") var brokeragePrice: String? = null,
    @SerializedName("sellingPrice") var sellingPrice: String? = null,
    @SerializedName("totalPrice") var totalPrice: String? = null,
    @SerializedName("finalPrice") var finalPrice: String? = null,
    @SerializedName("partyName") var partyName: String? = null,
    @SerializedName("brokerName") var brokerName: String? = null,
    @SerializedName("numberOfDays") var numberOfDays: String? = null,
    @SerializedName("detail") var detail: String? = null,
    @SerializedName("fianlOk") var fianlOk: String? = null,
    @SerializedName("numberWeight") var numberWeight: String? = null,
    @SerializedName("numberPrice") var numberPrice: String? = null,
    @SerializedName("numberPercentage") var numberPercentage: String? = null,
    @SerializedName("numberTotalPrice") var numberTotalPrice: String? = null,
    @SerializedName("numberPartyName") var numberPartyName: String? = null,
    @SerializedName("numberBrokerName") var numberBrokerName: String? = null,
    @SerializedName("numberDetail") var numberDetail: String? = null,
    @SerializedName("numberOk") var numberOk: String? = null,
    @SerializedName("finalDetail") var finalDetail: String? = null,
    @SerializedName("rowId") var rowId: String? = null
) : Serializable

