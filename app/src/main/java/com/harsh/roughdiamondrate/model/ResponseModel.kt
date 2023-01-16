package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("Message")
    var Message: String,
    @SerializedName("Status")
    var Status: String,
    @SerializedName("Data")
    var data: ArrayList<Data>
)
