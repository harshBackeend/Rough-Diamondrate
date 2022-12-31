package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import android.util.Log
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

class ShowPartyListViewModel : ViewModel() {

    fun getPartyList(context: Context): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }

        val requestModel = RequestModel(methodName = MethodName.getList)

        val url = Utility.getSharedPreferences(context, ApiUrlKey.firstUrl)
        viewModelScope.launchIO {
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {
                responseModel.postValue(result.body())
                Log.e("TAG", "setDataToApi: ${result.body()!!.Message}")
                Log.e("TAG", "getApi data : ${result.body()}")
            }
        }

        return responseModel
    }
}