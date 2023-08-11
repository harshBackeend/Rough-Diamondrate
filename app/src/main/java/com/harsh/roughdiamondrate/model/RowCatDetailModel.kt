package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class RowCatDetailModel(
    @SerializedName("cat") var cat: String? = null,
    @SerializedName("sKaWeight") var sKaWeight: String? = null,
    @SerializedName("sToWeight") var sToWeight: String? = null,
    @SerializedName("soKaWeight") var soKaWeight: String? = null,
    @SerializedName("soToWeight") var soToWeight: String? = null,
    @SerializedName("rowWeight") var rowWeight: String? = null,
    @SerializedName("w1") var w1: String? = null,
    @SerializedName("w2") var w2: String? = null,
    @SerializedName("w3") var w3: String? = null,
    @SerializedName("plate") var plate: String? = null,
    @SerializedName("total") var total: String? = null,
    @SerializedName("otherOut") var otherOut: String? = null,
    @SerializedName("afterTotal") var afterTotal: String? = null,
    @SerializedName("totalStone") var totalStone: String? = null,
    @SerializedName("totalWeight") var totalWeight: String? = null,
    @SerializedName("rowReady") var rowReady: String? = null,
    @SerializedName("date") var date: String? = null
)