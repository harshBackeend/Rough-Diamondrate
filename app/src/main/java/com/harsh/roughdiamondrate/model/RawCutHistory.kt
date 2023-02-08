package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RawCutHistory(

    @SerializedName("date") var data: String? = null,
    @SerializedName("mainKatNumber") var mainKatNumber: String? = null,
    @SerializedName("number") var number: String? = null,
    @SerializedName("katName") var katName: String? = null,
    @SerializedName("maineWeight") var maineWeight: String? = null,
    @SerializedName("bag") var bag: String? = null,
    @SerializedName("weight") var weight: String? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("dollarPrice") var dollarPrice: String? = null,
    @SerializedName("brokeragePrice") var brokeragePrice: String? = null,
    @SerializedName("sellingPrice") var sellingPrice: String? = null,
    @SerializedName("totalPrice") var totalPrice: String? = null,
    @SerializedName("numberWeight") var numberWeight: String? = null,
    @SerializedName("numberPrice") var numberPrice: String? = null,
    @SerializedName("numberPercentage") var numberPercentage: String? = null,
    @SerializedName("numberTotalPrice") var numberTotalPrice: String? = null,
    @SerializedName("finalPrice") var finalPrice: String? = null,
    @SerializedName("detail") var detail: String? = null,
    @SerializedName("month") var month: String? = null,
    @SerializedName("rowId") var rowId: String? = null
): Serializable
