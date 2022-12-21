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
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import com.harsh.roughdiamondrate.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMoneyDetailViewModel : ViewModel() {


    fun setDataToApi(
        dateValue: String,
        paltyName: String,
        deposit: String,
        depositNumber: String,
        withdrawal: String,
        withdrawalNumber: String,
        detail: String,
        context: Context
    ) :LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }

        val requestModel = RequestModel(
            dateValue = dateValue, paltyName = paltyName,
            deposit = deposit, depositNumber = depositNumber,
            withdrawal = withdrawal, withdrawalNumber = withdrawalNumber, detail = detail
        )
        Utility.printLog("startApi",dateValue)
        val url = Utility.getSharedPreferences(context, ApiUrlKey.firstUrl)
        viewModelScope.launchIO{
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {
                responseModel.postValue(result.body())
                Log.e("TAG", "setDataToApi: ${result.body()!!.Message}")
            }
        }

        return responseModel
    }

}