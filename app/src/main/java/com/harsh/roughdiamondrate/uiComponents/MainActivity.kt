@file:Suppress("NAME_SHADOWING")

package com.harsh.roughdiamondrate.uiComponents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityMainBinding
import com.harsh.roughdiamondrate.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getRate.observe(this) {
            Log.e("TAG", "onCreate: $it")
            if (it > 0) {
                binding.textPolishReport.text = it.toString()
                binding.layoutPolishReport.visibility = View.VISIBLE
            } else {
                binding.layoutPolishReport.visibility = View.GONE
            }

        }
        viewModel.getResponseModel.observe(this){
            if(it != null){
                if(it.Status.equals("1")){
                    startActivity(Intent(this,AddMoneyDetailActivity::class.java))
                }else{
                    Toast.makeText(this,it.Message,Toast.LENGTH_LONG).show()
                }
            }
        }


        binding.buttonGetRate.setOnClickListener {
            if (checkError()) {
                viewModel.getRateFromUi(
                    Utility.getTextFromEditText(binding.editRFPrice),
                    Utility.getTextFromEditText(binding.editRFTaka),
                    Utility.getTextFromEditText(binding.editDiamondSize),
                    Utility.getTextFromEditText(binding.editDiamondMajuri),
                    Utility.getTextFromEditText(binding.editDiamondPolishResult),
                    Utility.getTextFromEditText(binding.editProfitInPercentage)
                )
            } else {
                if (Utility.getTextFromEditText(binding.editRFPrice).isEmpty() &&
                    Utility.getTextFromEditText(binding.editRFTaka).isEmpty() &&
                    Utility.getTextFromEditText(binding.editDiamondSize).isNotEmpty() &&
                    Utility.getTextFromEditText(binding.editDiamondMajuri).isEmpty() &&
                    Utility.getTextFromEditText(binding.editDiamondPolishResult).isEmpty() &&
                    Utility.getTextFromEditText(binding.editProfitInPercentage).isEmpty()
                ) {
                    viewModel.getUrl(Utility.getTextFromEditText(binding.editDiamondSize),this)
                }
            }
        }
        binding.buttonReset.setOnClickListener {
            binding.editRFPrice.text = null
            binding.editRFTaka.text = null
            binding.editDiamondSize.text = null
            binding.editDiamondMajuri.text = null
            binding.editDiamondPolishResult.text = null
            binding.editProfitInPercentage.text = null
            viewModel.resetRateData()
        }
    }

    private fun checkError(): Boolean {
        return if (Utility.getTextFromEditText(binding.editRFPrice).isEmpty()) {
            false
        } else if (Utility.getTextFromEditText(binding.editRFTaka).isEmpty()) {
            false
        } else if (Utility.getTextFromEditText(binding.editDiamondSize).isEmpty()) {
            false
        } else if (Utility.getTextFromEditText(binding.editDiamondMajuri).isEmpty()) {
            false
        } else if (Utility.getTextFromEditText(binding.editDiamondPolishResult).isEmpty()) {
            false
        } else if (Utility.getTextFromEditText(binding.editProfitInPercentage).isEmpty()) {
            true
        } else {
            true
        }
    }


}