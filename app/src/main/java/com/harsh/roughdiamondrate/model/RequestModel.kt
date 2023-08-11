package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class RequestModel(

    @SerializedName("code")
    var code: String? = null,

    //addMoneyDetail
    @SerializedName("dateValue")
    var dateValue: String? = null,
    @SerializedName("paltyName")
    var paltyName: String? = null,
    @SerializedName("deposit")
    var deposit: String? = null,
    @SerializedName("depositNumber")
    var depositNumber: String? = null,
    @SerializedName("withdrawal")
    var withdrawal: String? = null,
    @SerializedName("withdrawalNumber")
    var withdrawalNumber: String? = null,
    @SerializedName("detail")
    var detail: String? = null,
    @SerializedName("methodName")
    var methodName: String? = null,

    //RawCutEntry
    @SerializedName("mainKatNumber")
    var mainKatNumber: String? = null,
    @SerializedName("katName")
    var katName: String? = null,
    @SerializedName("maineWeight")
    var maineWeight: String? = null,
    @SerializedName("bag")
    var bag: String? = null,
    @SerializedName("weight")
    var weight: String? = null,
    @SerializedName("price")
    var price: String? = null,
    @SerializedName("dollarPrice")
    var dollarPrice: String? = null,
    @SerializedName("brokeragePrice")
    var brokeragePrice: String? = null,
    @SerializedName("sellingPrice")
    var sellingPrice: String? = null,
    @SerializedName("totalPrice")
    var totalPrice: String? = null,
    @SerializedName("finalPrice")
    var finalPrice: String? = null,
    @SerializedName("partyName")
    var partyName: String? = null,
    @SerializedName("brokerName")
    var brokerName: String? = null,
    @SerializedName("numberOfDays")
    var numberOfDays: String? = null,
    @SerializedName("fianlOk")
    var fianlOk: String? = null,
    @SerializedName("numberWeight")
    var numberWeight: String? = null,
    @SerializedName("numberPrice")
    var numberPrice: String? = null,
    @SerializedName("numberPercentage")
    var numberPercentage: String? = null,
    @SerializedName("numberTotalPrice")
    var numberTotalPrice: String? = null,
    @SerializedName("numberPartyName")
    var numberPartyName: String? = null,
    @SerializedName("numberBrokerName")
    var numberBrokerName: String? = null,
    @SerializedName("numberDetail")
    var numberDetail: String? = null,
    @SerializedName("numberOk")
    var numberOk: String? = null,
    @SerializedName("finalDetail")
    var finalDetail: String? = null,
    @SerializedName("no")
    var no: String? = null,
    @SerializedName("veWeight")
    var veWeight: String? = null,
    @SerializedName("percentage")
    var percentage: String? = null,
    @SerializedName("peroti")
    var peroti: String? = null,
    @SerializedName("payment")
    var payment: String? = null,
    @SerializedName("cvd")
    var cvd: String? = null,
    @SerializedName("brokeragePercentage")
    var brokeragePercentage: String? = null,
    @SerializedName("paymentDetail")
    var paymentDetail: String? = null,
    @SerializedName("ok")
    var ok: String? = null,
    @SerializedName("rowId")
    var rowId: String? = null,
    @SerializedName("catNumber")
    var catNumber: String? = null
)