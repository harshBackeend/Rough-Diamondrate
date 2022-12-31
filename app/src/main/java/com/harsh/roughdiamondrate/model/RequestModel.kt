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
    var methodName: String? = null
)