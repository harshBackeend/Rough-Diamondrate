package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("Message")
    var Message: String,
    @SerializedName("Status")
    var Status: String,
    @SerializedName("totalAmount")
    var totalAmount: String,
    @SerializedName("Data")
    var data: ArrayList<Data>,
    @SerializedName("RawCutHistory")
    var rawCutHistory: ArrayList<RawCutHistory>,
    @SerializedName("taiyarVeList")
    var taiyarVeList: ArrayList<TaiyarVeList>,
    @SerializedName("RowCatDetail")
    var rowCatDetail:RowCatDetailModel? = null,
    @SerializedName("ReadyCatDetail")
    var readyCatDetail:ReadyCatDetailModel? = null
)
