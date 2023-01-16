package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("url") var url: String? = null,
    @SerializedName("partyName") var partyName: String? = null,
    @SerializedName("partyTotal") var partyTotal: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("deposit") var deposit: String? = null,
    @SerializedName("depositNo") var depositNo: String? = null,
    @SerializedName("credit") var credit: String? = null,
    @SerializedName("creditNo") var creditNo: String? = null,
    @SerializedName("detail") var detail: String? = null


)
