package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.Utility.Companion.launchIO
import com.harsh.roughdiamondrate.model.ApiUrlKey
import com.harsh.roughdiamondrate.model.MethodName
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import com.harsh.roughdiamondrate.repository.MainRepository

class RawCutDetailViewModel : ViewModel() {

    fun setDataToApi(
        dateValue: String,
        mainKatNumber: String,
        katName: String,
        maineWeight: String,
        bag: String,
        weight: String,
        price: String,
        dollarPrice: String,
        brokeragePrice: String,
        sellingPrice: String,
        totalPrice: String,
        finalPrice: String,
        partyName: String,
        brokerName: String,
        numberOfDays: String,
        detail: String,
        fianlOk: String,
        numberWeight: String,
        numberPrice: String,
        numberPercentage: String,
        numberTotalPrice: String,
        numberPartyName: String,
        numberBrokerName: String,
        numberDetail: String,
        numberOk: String,
        finalDetail: String,
        context: Context,
        rowId: String = "0"
    ): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }

        val requestModel = RequestModel(
            dateValue = dateValue,
            mainKatNumber = mainKatNumber,
            katName = katName,
            maineWeight = maineWeight,
            bag = bag,
            weight = weight,
            price = price,
            dollarPrice = dollarPrice,
            brokeragePrice = brokeragePrice,
            sellingPrice = sellingPrice,
            totalPrice = totalPrice,
            finalPrice = finalPrice,
            partyName = partyName,
            brokerName = brokerName,
            numberOfDays = numberOfDays,
            detail = detail,
            fianlOk = fianlOk,
            numberWeight = numberWeight,
            numberPrice = numberPrice,
            numberPercentage = numberPercentage,
            numberTotalPrice = numberTotalPrice,
            numberPartyName = numberPartyName,
            numberBrokerName = numberBrokerName,
            numberDetail = numberDetail,
            numberOk = numberOk,
            finalDetail = finalDetail,
            methodName = MethodName.insertData,
            rowId = rowId
        )

        val url = Utility.getSharedPreferences(context, ApiUrlKey.secondUrl)
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