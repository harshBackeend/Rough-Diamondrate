package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.Utility.Companion.launchIO
import com.harsh.roughdiamondrate.model.ApiUrlKey
import com.harsh.roughdiamondrate.model.MethodName
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import com.harsh.roughdiamondrate.repository.MainRepository

class TaiyarVeEnteryViewModel: ViewModel() {


    fun addDataToTaiyarVe(
        dateValue: String,
        no: String,
        weight: String,
        veWeight: String,
        price: String,
        percentage: String,
        payment: String,
        perotti: String,
        paltyName: String,
        brokerName: String,
        numberDays: String,
        cvdDiamond: String,
        brokeragePercentage: String,
        brokeragePrice: String,
        afterBrokerage: String,
        paymentDetail: String,
        detail: String,
        ok: String,
        context: Context,
        rowId: String = "0"
    ): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }

        val requestModel = RequestModel(
            dateValue = dateValue,
            no = no,
            weight = weight,
            veWeight = veWeight,
            price = price,
            percentage = percentage,
            payment = payment,
            peroti = perotti,
            partyName = paltyName,
            brokerName = brokerName,
            numberOfDays = numberDays,
            cvd = cvdDiamond,
            brokeragePercentage = brokeragePercentage,
            brokeragePrice = brokeragePrice,
            finalPrice = afterBrokerage,
            paymentDetail = paymentDetail,
            detail = detail,
            ok = ok,
            rowId = rowId,
            methodName = MethodName.setTaiyarVeData
        )
        Utility.printLog("startApi", dateValue)
        val url = Utility.getSharedPreferences(context, ApiUrlKey.veFile)
        Utility.printLog("Api Url","$url")
        Utility.printLog("RequestModel","$requestModel")
        viewModelScope.launchIO {
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {
                responseModel.postValue(result.body())
                Utility.printLog("TAG", "setDataToApi: ${result.body()!!.Message}")
                Utility.printLog("TAG", "getApi data : ${result.body()}")
            }
        }

        return responseModel
    }

}