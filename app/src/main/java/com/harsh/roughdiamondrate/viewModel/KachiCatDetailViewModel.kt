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
import com.harsh.roughdiamondrate.model.ReadyCatDetailModel
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import com.harsh.roughdiamondrate.model.RowCatDetailModel
import com.harsh.roughdiamondrate.repository.MainRepository

class KachiCatDetailViewModel : ViewModel() {

    fun getRowKatDetail(cat: String, context: Context): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }
        val requestModel = RequestModel(catNumber = cat, methodName = MethodName.getRowCatDetail)
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

    fun setRowKatDetailInSheet(
        rowCatDetailModel: RowCatDetailModel,
        context: Context
    ): LiveData<ResponseModel> {
        val requestModel = RequestModel(
            cat = rowCatDetailModel.cat,
            sKaWeight = rowCatDetailModel.sKaWeight,
            sToWeight = rowCatDetailModel.sToWeight,
            soKaWeight = rowCatDetailModel.soKaWeight,
            soToWeight = rowCatDetailModel.soToWeight,
            rowWeight = rowCatDetailModel.rowWeight,
            w1 = rowCatDetailModel.w1,
            w2 = rowCatDetailModel.w2,
            w3 = rowCatDetailModel.w3,
            plate = rowCatDetailModel.plate,
            total = rowCatDetailModel.total,
            otherOut = rowCatDetailModel.otherOut,
            afterTotal = rowCatDetailModel.afterTotal,
            totalStone = rowCatDetailModel.totalStone,
            totalWeight = rowCatDetailModel.totalWeight,
            rowReady = rowCatDetailModel.rowReady,
            dateValue = rowCatDetailModel.date,
            methodName = MethodName.setRowCatDetail
        )
        val responseModel by lazy { MutableLiveData<ResponseModel>() }
        val url = Utility.getSharedPreferences(context, ApiUrlKey.entryFile)
        Utility.printLog("date",rowCatDetailModel.date+"")
        Utility.printLog("RequestModel",requestModel.toString())
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