package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("Url") var Url: String? = null,
    @SerializedName("Message") var Message: String? = null,
    @SerializedName("Status") var Status: String? = null,
    @SerializedName("Data") var data: ArrayList<Data>? = null
)
