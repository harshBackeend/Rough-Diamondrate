package com.harsh.roughdiamondrate.uiComponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityFilterBinding
import com.harsh.roughdiamondrate.model.ApiUrlKey
import com.harsh.roughdiamondrate.model.RequestModel
import com.harsh.roughdiamondrate.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.getData.setOnClickListener {
            val url = Utility.getSharedPreferences(this@FilterActivity,ApiUrlKey.firstUrl)
            val requestModel = RequestModel(college = "dishant", filter = Utility.getTextFromEditText(binding.editKatNumber))
            MainScope().launch(Dispatchers.IO){
                val result = MainRepository(url!!).getData(requestModel)
                if (result.body() != null) {
                    Log.e("getUrl", "getUrl: ${result.body()!!.data.toString()}")
                    Log.e("getUrl", "getMessage: ${result.body()!!.Message}")
                    Log.e("getUrl", "getStatus: ${result.body()!!.Status}")
                    runOnUiThread {
                        binding.editKatStatus.text = result.body()!!.data.toString()
                    }
                }
            }
        }*/
    }
}