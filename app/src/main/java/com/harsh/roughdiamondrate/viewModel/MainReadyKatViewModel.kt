package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.Utility.Companion.launchIO
import com.harsh.roughdiamondrate.model.ApiUrlKey
import com.harsh.roughdiamondrate.model.MethodName
import com.harsh.roughdiamondrate.model.ReadyCatDetailModel
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import com.harsh.roughdiamondrate.repository.MainRepository

class MainReadyKatViewModel : ViewModel() {

    fun getReadyKatDetail(cat: String, context: Context): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }
        val requestModel = RequestModel(catNumber = cat, methodName = MethodName.getReadyCatDetail)
        val url = Utility.getSharedPreferences(context, ApiUrlKey.entryFile)
        viewModelScope.launchIO {
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {
                if (result.body()!!.Status == "1") {
                    responseModel.postValue(result.body())
                    Utility.printLog("TAG", "setDataToApi: ${result.body()!!.Message}")
                    Utility.printLog("TAG", "getApi data : ${result.body()}")
                }
            }
        }
        return responseModel
    }

    fun setReadyKatDetailInSheet(
        readyCatDetailModel: ReadyCatDetailModel,
        context: Context
    ): LiveData<ResponseModel> {
        val requestModel = RequestModel(
            cat = readyCatDetailModel.cat,
            sumAfterTotal = readyCatDetailModel.sumAfterTotal,
            total4POkNumber = readyCatDetailModel.total4POkNumber,
            total4POkWeight = readyCatDetailModel.total4POkWeight,
            avgPrient = readyCatDetailModel.avgPrient,
            avgW1 = readyCatDetailModel.avgW1,
            avgW2 = readyCatDetailModel.avgW2,
            avgW3 = readyCatDetailModel.avgW3,
            avgGoli = readyCatDetailModel.avgGoli,
            avgAPlus = readyCatDetailModel.avgAPlus,
            avgPalsa = readyCatDetailModel.avgPalsa,
            avgGoliWeight = readyCatDetailModel.avgGoliWeight,
            avgAPlusWeight = readyCatDetailModel.avgAPlusWeight,
            avgPalsaWeight = readyCatDetailModel.avgPalsaWeight,
            avgNew = readyCatDetailModel.avgNew,
            totalPataNo = readyCatDetailModel.totalPataNo,
            totalPataWeight = readyCatDetailModel.totalPataWeight,
            avgFinal = readyCatDetailModel.avgFinal,
            totalToWeight = readyCatDetailModel.totalToWeight,
            totalToNo = readyCatDetailModel.totalToNo,
            total1 = readyCatDetailModel.total1,
            total2 = readyCatDetailModel.total2,
            total3 = readyCatDetailModel.total3,
            totalRowNo = readyCatDetailModel.totalRowNo,
            totalRowWeight = readyCatDetailModel.totalRowWeight,
            totalReadyNo = readyCatDetailModel.totalReadyNo,
            totalReadyWeight = readyCatDetailModel.totalReadyWeight,
            date = readyCatDetailModel.date,
            methodName = MethodName.setReadyCatDetail
        )
        val responseModel by lazy { MutableLiveData<ResponseModel>() }
        val url = Utility.getSharedPreferences(context, ApiUrlKey.entryFile)
        viewModelScope.launchIO {
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {
                if (result.body()!!.Status == "1") {
                    responseModel.postValue(result.body())
                    Utility.printLog("TAG", "setDataToApi: ${result.body()!!.Message}")
                    Utility.printLog("TAG", "getApi data : ${result.body()}")
                }
            }
        }

        return responseModel
    }


}