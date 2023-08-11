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
        val responseModel by lazy { MutableLiveData<ResponseModel>() }
//        val requestModel = RequestModel(catNumber = cat, methodName = MethodName.getReadyCatDetail)
        val url = Utility.getSharedPreferences(context, ApiUrlKey.entryFile)

        return responseModel
    }


}