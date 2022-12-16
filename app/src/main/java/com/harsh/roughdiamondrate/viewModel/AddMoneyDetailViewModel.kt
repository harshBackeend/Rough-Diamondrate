package com.harsh.roughdiamondrate.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.roughdiamondrate.Utility
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
    ): Boolean {

        val requestModel = RequestModel(
            dateValue = dateValue, paltyName = paltyName,
            deposit = deposit, depositNumber = depositNumber,
            withdrawal = withdrawal, withdrawalNumber = withdrawalNumber, detail = detail
        )
        var apiResponse: ResponseModel? = null
        val url = Utility.getSharedPreferences(context, ApiUrlKey.firstUrl)
        viewModelScope.launch(Dispatchers.IO){
            val result = MainRepository(url!!).getData(requestModel)
            if (result.body() != null) {
                apiResponse = result.body()
            }
        }
        Toast.makeText(context,apiResponse!!.Message,Toast.LENGTH_LONG).show()
        return apiResponse!!.Status.equals("1")

    }

}