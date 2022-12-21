package com.harsh.roughdiamondrate.repository

import com.harsh.roughdiamondrate.apiCall.ApiInterface
import com.harsh.roughdiamondrate.apiCall.RetrofitHelper
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import retrofit2.Response

class MainRepository(baseUrl:String) {

    @Volatile
    lateinit var apiInterface: ApiInterface

    init {
      /*  if (apiInterface == null){*/
            apiInterface = RetrofitHelper.getInstance(baseUrl).create(ApiInterface::class.java)
//        }
    }

    suspend fun getData(password:RequestModel):Response<ResponseModel> = apiInterface.getData(password)
}