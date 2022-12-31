package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("url")
    var url: String? = null,
    @SerializedName("partyName")
    var partyName: String? = null,
    @SerializedName("partyTotal")
    var partyTotal: String? = null
)
