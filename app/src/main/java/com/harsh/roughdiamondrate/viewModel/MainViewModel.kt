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

class MainViewModel : ViewModel() {

    val baseUrl = "https://script.google.com/macros/s/AKfycbx68bdreUEcNGx8xAp_d2F49lbPeJxihRNKaDTWdXLsAK3gUsKYA9ImKeAzsL2CtWwj/"

    private val getRateData by lazy { MutableLiveData<Float>() }
    val getRate: LiveData<Float>
        get() = getRateData


    @Suppress("NAME_SHADOWING")
    fun getRateFromUi(
        editRFPrice: String,
        editRFTaka: String,
        editDiamondSize: String,
        editDiamondMajuri: String,
        editDiamondPolishResult: String,
        editProfitInPercentage: String
    ) {


        val editRFPrice: Float? = editRFPrice.trim().toFloatOrNull()
        val editRFTaka: Float? = editRFTaka.toFloatOrNull()
        val editDiamondSize: Float? = editDiamondSize.toFloatOrNull()
        val editDiamondMajuri: Float? = editDiamondMajuri.toFloatOrNull()
        val editDiamondPolishResult: Float? = editDiamondPolishResult.toFloatOrNull()
        val editProfitInPercentage: Float? = editProfitInPercentage.toFloatOrNull()
        val constant = 100

        getRateData.postValue((((editRFPrice!! / (editRFTaka!! / constant)) + (editDiamondMajuri!! * editDiamondSize!!)) / (editDiamondPolishResult!! / constant)))
    }

    fun resetRateData() {
        getRateData.postValue(0F)
    }

    fun getUrl(password: String, context: Context): LiveData<ResponseModel> {
        val responseModel by lazy { MutableLiveData<ResponseModel>() }
        val requestModel = RequestModel(code = password)
        viewModelScope.launchIO {
            val result = MainRepository(baseUrl).getData(requestModel)
            if (result.body() != null) {
                if (result.body()!!.Status.equals("1")) {
                    val url = result.body()!!.data!![0].url
                    Log.e("TAG", "getUrl: $url")
                    Utility.setSharedPreferences(context, ApiUrlKey.firstUrl, url!!)
                }
                responseModel.postValue(result.body())
            }
        }
        return responseModel
    }

}

