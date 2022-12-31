package com.harsh.roughdiamondrate.apiCall

import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.model.ResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("exec")
    suspend fun getData(@Body requestModel: RequestModel): Response<ResponseModel>

}