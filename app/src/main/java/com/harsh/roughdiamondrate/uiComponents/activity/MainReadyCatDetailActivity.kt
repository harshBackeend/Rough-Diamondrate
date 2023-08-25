package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowId.FocusObserver
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityMainReadyCatDetailBinding
import com.harsh.roughdiamondrate.model.ReadyCatDetailModel
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.KachiCatDetailViewModel
import com.harsh.roughdiamondrate.viewModel.MainReadyKatViewModel

class MainReadyCatDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainReadyCatDetailBinding
    lateinit var viewModel: MainReadyKatViewModel
    private lateinit var progressBar: Dialog
    private lateinit var readyCatDetailModel: ReadyCatDetailModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainReadyCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainReadyKatViewModel::class.java]

        binding.layoutDate.visibility = View.GONE;
        binding.buttonSend.visibility = View.VISIBLE;


        binding.buttonReset.setOnClickListener {
            binding.layoutDate.visibility = View.GONE
            binding.layoutMainData.visibility = View.GONE
            binding.buttonSend.visibility = View.VISIBLE
            binding.editCat.setText("")
            binding.editDate.setText("")
            binding.editSumAfterTotal.setText("")
            binding.editSum4pOkNumber.setText("")
            binding.editSum4pOkWeight.setText("")
            binding.editAvgPrintP.setText("")
            binding.editSum4pOkWeight.setText("")
            binding.editAvgGoli.setText("")
            binding.editAvgA.setText("")
            binding.editAvgPalsa.setText("")
            binding.editSumPataNumber.setText("")
            binding.editAvgFileP.setText("")
            binding.editSumPataWeight.setText("")
            binding.editSumToNumber.setText("")
            binding.editSumToWeight.setText("")
            binding.editSum1.setText("")
            binding.editSum2.setText("")
            binding.editSum3.setText("")
            binding.editSumRowNumber.setText("")
            binding.editSumRowWeight.setText("")
            binding.editSumReadyNumber.setText("")
            binding.editSumReadyWeight.setText("")
        }

        binding.buttonSend.setOnClickListener {
            if (Utility.getTextFromEditText(binding.editCat).isNotEmpty()) {
                progressBar = ProgressBar.getDialog(this)
                progressBar.setCancelable(false)
                progressBar.show()
                viewModel.getReadyKatDetail(Utility.getTextFromEditText(binding.editCat), this)
                    .observe(this) {
                        progressBar.dismiss()
                        if (it.Status == "1") {
                            binding.buttonSend.visibility = View.GONE
                            binding.layoutDate.visibility = View.VISIBLE
                            binding.layoutMainData.visibility = View.VISIBLE
                            binding.editCat.isFocusable = false
                            readyCatDetailModel = it.readyCatDetail!!
                            binding.editCat.setText(readyCatDetailModel.cat)
                            binding.editDate.setText(readyCatDetailModel.date)
                            binding.editSumAfterTotal.setText(readyCatDetailModel.sumAfterTotal)
                            binding.editSum4pOkNumber.setText(readyCatDetailModel.total4POkNumber)
                            binding.editSum4pOkWeight.setText(readyCatDetailModel.total4POkWeight)
                            binding.editAvgPrintP.setText(readyCatDetailModel.avgPrient)
                            binding.editSum4pOkWeight.setText(readyCatDetailModel.total4POkWeight)
                            binding.editAvgGoli.setText(readyCatDetailModel.avgGoli)
                            binding.editAvgA.setText(readyCatDetailModel.avgAPlus)
                            binding.editAvgPalsa.setText(readyCatDetailModel.avgPalsa)
                            binding.editSumPataNumber.setText(readyCatDetailModel.totalPataNo)
                            binding.editAvgFileP.setText(readyCatDetailModel.avgFinal)
                            binding.editSumPataWeight.setText(readyCatDetailModel.totalPataWeight)
                            binding.editSumToNumber.setText(readyCatDetailModel.totalToNo)
                            binding.editSumToWeight.setText(readyCatDetailModel.totalToWeight)
                            binding.editSum1.setText(readyCatDetailModel.total1)
                            binding.editSum2.setText(readyCatDetailModel.total2)
                            binding.editSum3.setText(readyCatDetailModel.total3)
                            binding.editSumRowNumber.setText(readyCatDetailModel.totalRowNo)
                            binding.editSumRowWeight.setText(readyCatDetailModel.totalRowWeight)
                            binding.editSumReadyNumber.setText(readyCatDetailModel.totalReadyNo)
                            binding.editSumReadyWeight.setText(readyCatDetailModel.totalReadyWeight)
                            progressBar.dismiss()
                        } else {
                            progressBar.dismiss()
                        }
                    }

            }

        }

        binding.buttonSendEntry.setOnClickListener {
            if (binding.layoutMainData.visibility == View.VISIBLE) {
                progressBar = ProgressBar.getDialog(this)
                progressBar.setCancelable(false)
                progressBar.show()
                viewModel.setReadyKatDetailInSheet(readyCatDetailModel, this).observe(this) {
                    if (it.Status == "1") {
                        binding.buttonReset.performClick()
                        progressBar.dismiss()
                    } else {
                        progressBar.dismiss()
                    }
                }
            }
        }
    }
}