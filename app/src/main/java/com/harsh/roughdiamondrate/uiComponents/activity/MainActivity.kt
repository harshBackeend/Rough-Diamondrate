@file:Suppress("NAME_SHADOWING")

package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityMainBinding
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getRate.observe(this) {
            Log.e("TAG", "onCreate: $it")
            binding.buttonGetRate.isEnabled = true
            if (it > 0) {
                binding.textPolishReport.text = it.toString()
                binding.layoutPolishReport.visibility = View.VISIBLE
            } else {
                binding.layoutPolishReport.visibility = View.GONE
            }
        }


        binding.buttonGetRate.setOnClickListener {
            binding.buttonGetRate.isEnabled = false
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
                    progressBar = ProgressBar.getDialog(this)
                    progressBar.setCancelable(false)
                    progressBar.show()
                    viewModel.getUrl(Utility.getTextFromEditText(binding.editDiamondSize), this)
                        .observe(this) {
                            binding.buttonGetRate.isEnabled = true
                            if (it.Status.equals("1")) {
                                progressBar.dismiss()
                                binding.editDiamondSize.text.clear()
                                startActivity(Intent(this, MenuActivity::class.java))
                                finish()
                            } else {
                                progressBar.dismiss()
                                Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                            }
                        }
                }
            }
        }
        binding.buttonReset.setOnClickListener {
            binding.editRFPrice.text.clear()
            binding.editRFTaka.text.clear()
            binding.editDiamondSize.text.clear()
            binding.editDiamondMajuri.text.clear()
            binding.editDiamondPolishResult.text.clear()
            binding.editProfitInPercentage.text.clear()
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