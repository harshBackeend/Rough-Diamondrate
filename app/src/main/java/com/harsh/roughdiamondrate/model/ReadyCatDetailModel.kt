package com.harsh.roughdiamondrate.model

import com.google.gson.annotations.SerializedName

data class ReadyCatDetailModel(
    @SerializedName("cat") var cat: String? = null,
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