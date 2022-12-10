package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("college") var college: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("state") var state: String? = null
)
