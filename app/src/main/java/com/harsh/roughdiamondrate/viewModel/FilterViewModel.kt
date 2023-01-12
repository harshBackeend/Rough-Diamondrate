package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harsh.roughdiamondrate.model.MethodName
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel

class FilterViewModel : ViewModel() {

    fun getHistory(context: Context, partyName: String):LiveData<ResponseModel>{
        val responseModel by lazy { MutableLiveData<ResponseModel>() }

        val requestModel = RequestModel(methodName = MethodName.getList)
    }
}