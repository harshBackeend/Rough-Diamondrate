package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.model.ApiUrlKey
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddMoneyDetailViewModel : ViewModel() {

    private var dataShow: MutableLiveData<Boolean> = MutableLiveData()
    val getData: LiveData<Boolean>
        get() = dataShow


    fun setDataToApi(
        dateValue: String,
        paltyName: String,
        deposit: String,
        depositNumber: String,
        withdrawal: String,
        withdrawalNumber: String,
        detail: String,
        context: Context
    ) {

        val requestModel = RequestModel(
            dateValue = dateValue, paltyName = paltyName,
            deposit = deposit, depositNumber = depositNumber,
            withdrawal = withdrawal, withdrawalNumber = withdrawalNumber, detail = detail
        )
        Utility.printLog("startApi",dateValue)
        val url = Utility.getSharedPreferences(context, ApiUrlKey.firstUrl)
        viewModelScope.async(Dispatchers.IO) {
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {

                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, result.body()!!.Message, Toast.LENGTH_LONG).show()
                }
                if (result.body()!!.Status.equals("1")) {
                    dataShow.postValue(true)
                } else {
                    dataShow.postValue(false)
                }
                Log.e("TAG", "setDataToApi: ${result.body()!!.Message}")
            }
        }
//        return if(job.isCompleted){
//            apiResponse!!.Status.equals("1")
//        }else{
//            false
//        }

    }

}