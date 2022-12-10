package com.harsh.roughdiamondrate.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val baseUrl =
        "https://script.google.com/macros/s/AKfycbxCKbQyGmAZi6xrCJu5orWIYgynY-Dx3PA0dD2ZlypJG43fltgXNJuPLvQxgcXXxxnb6Q/"

    private val getRateData = MutableLiveData<Float>()
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

    fun getUrl(password: String) {
        Log.e("ViewModel", "getUrl: Api call")
        val requestModel:RequestModel = RequestModel(password, filter = "")
        requestModel.college = password
        viewModelScope.launch(Dispatchers.IO) {
            val result = MainRepository(baseUrl).getData(requestModel)
            if (result.body() != null) {
                Log.e("getUrl", "getUrl: ${result.body()!!.Url}", )
                Log.e("getUrl", "getMessage: ${result.body()!!.Message}", )
                Log.e("getUrl", "getStatus: ${result.body()!!.Status}", )
                if (result.body()!!.Status.equals("1")) {
                    val url = result.body()!!.Url
                    requestModel.college = "dishant"
                    requestModel.filter = "National Institute of Technology Rourkela"
                    viewModelScope.launch(Dispatchers.IO) {
                        val result2 = MainRepository(url!!).getData(requestModel)
                        if (result2.body() != null) {
                            Log.e("getUrl", "getUrl: ${result2.body()!!.data.toString()}")
                            Log.e("getUrl", "getMessage: ${result2.body()!!.Message}")
                            Log.e("getUrl", "getStatus: ${result2.body()!!.Status}")
                        }

                    }
                }
            }
        }

    }


}

