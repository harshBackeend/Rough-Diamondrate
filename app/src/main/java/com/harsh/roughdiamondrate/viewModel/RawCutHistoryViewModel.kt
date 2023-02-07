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

class RawCutHistoryViewModel : ViewModel() {

    fun getHistoryOfRawCut(context: Context): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }

        val requestModel = RequestModel(methodName = MethodName.getHistory)
        val url = Utility.getSharedPreferences(context, ApiUrlKey.secondUrl)
        viewModelScope.launchIO {
            val result = MainRepository(url!!).getData(requestModel)
            if(result.body() != null){
                responseModel.postValue(result.body())
                Utility.printLog("TAG", "setDataToApi: ${result.body()!!.Message}")
                Utility.printLog("TAG", "getApi data : ${result.body()}")
            }
        }
        return responseModel
    }
}