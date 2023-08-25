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
    var catNumber: String? = null,
    @SerializedName("cat")
    var cat: String? = null,
    @SerializedName("sumAfterTotal") var sumAfterTotal: String? = null,
    @SerializedName("total4POkNumber") var total4POkNumber: String? = null,
    @SerializedName("total4POkWeight") var total4POkWeight: String? = null,
    @SerializedName("avgPrient") var avgPrient: String? = null,
    @SerializedName("avgW1") var avgW1: String? = null,
    @SerializedName("avgW2") var avgW2: String? = null,
    @SerializedName("avgW3") var avgW3: String? = null,
    @SerializedName("avgGoli") var avgGoli: String? = null,
    @SerializedName("avgAPlus") var avgAPlus: String? = null,
    @SerializedName("avgPalsa") var avgPalsa: String? = null,
    @SerializedName("avgGoliWeight") var avgGoliWeight: String? = null,
    @SerializedName("avgAPlusWeight") var avgAPlusWeight: String? = null,
    @SerializedName("avgPalsaWeight") var avgPalsaWeight: String? = null,
    @SerializedName("avgNew") var avgNew: String? = null,
    @SerializedName("totalPataNo") var totalPataNo: String? = null,
    @SerializedName("totalPataWeight") var totalPataWeight: String? = null,
    @SerializedName("avgFinal") var avgFinal: String? = null,
    @SerializedName("totalToWeight") var totalToWeight: String? = null,
    @SerializedName("totalToNo") var totalToNo: String? = null,
    @SerializedName("total1") var total1: String? = null,
    @SerializedName("total2") var total2: String? = null,
    @SerializedName("total3") var total3: String? = null,
    @SerializedName("totalRowNo") var totalRowNo: String? = null,
    @SerializedName("totalRowWeight") var totalRowWeight: String? = null,
    @SerializedName("totalReadyNo") var totalReadyNo: String? = null,
    @SerializedName("totalReadyWeight") var totalReadyWeight: String? = null,
    @SerializedName("date") var date: String? = null
)