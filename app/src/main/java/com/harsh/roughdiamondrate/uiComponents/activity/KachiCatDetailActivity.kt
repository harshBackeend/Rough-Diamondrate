package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityKachiCatDetailBinding
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeEnteryBinding
import com.harsh.roughdiamondrate.model.ReadyCatDetailModel
import com.harsh.roughdiamondrate.model.RowCatDetailModel
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.KachiCatDetailViewModel

class KachiCatDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityKachiCatDetailBinding
    lateinit var viewModel: KachiCatDetailViewModel
    private lateinit var progressBar: Dialog
    private lateinit var rowCatDetailModel: RowCatDetailModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKachiCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[KachiCatDetailViewModel::class.java]

        binding.buttonReset.setOnClickListener {
            binding.layoutData.visibility = View.GONE
            binding.layoutDate.visibility = View.GONE
            binding.buttonSend.visibility = View.VISIBLE
            binding.editCat.isFocusable = true
            binding.editCat.setText("")
            binding.editDate.setText("")
            binding.editSKaWeight.setText("")
            binding.editSToWeight.setText("")
            binding.editSP.setText("")
            binding.editSoKaWeight.setText("")
            binding.editSoToWeight.setText("")
            binding.editSoP.setText("")
            binding.editRowWeight.setText("")
            binding.editPalet.setText("")
            binding.editW1.setText("")
            binding.editW1P.setText("")
            binding.editW2.setText("")
            binding.editW2P.setText("")
            binding.editW3.setText("")
            binding.editW3P.setText("")
            binding.editTotal.setText("")
            binding.editOtherHpOut.setText("")
            binding.editAfterTotal.setText("")
            binding.editTotalNag.setText("")
            binding.editTotalWeight.setText("")
            binding.editRowReady.setText("")
        }

        binding.buttonReset.performClick()

        binding.buttonSendEntry.setOnClickListener {
            if (binding.layoutData.visibility == View.VISIBLE) {
                progressBar = ProgressBar.getDialog(this)
                progressBar.setCancelable(false)
                progressBar.show()
                viewModel.setRowKatDetailInSheet(rowCatDetailModel, this).observe(this) {
                    if (it.Status == "1") {
                        binding.buttonReset.performClick()
                        progressBar.dismiss()
                    } else {
                        progressBar.dismiss()
                    }
                }
            }
        }
        binding.buttonSend.setOnClickListener {
            if (Utility.getTextFromEditText(binding.editCat).isNotEmpty()) {
                progressBar = ProgressBar.getDialog(this)
                progressBar.setCancelable(false)
                progressBar.show()
                viewModel.getRowKatDetail(Utility.getTextFromEditText(binding.editCat), this)
                    .observe(this) {
                        progressBar.dismiss()
                        if (it.Status == "1") {
                            binding.buttonSend.visibility = View.GONE
                            binding.layoutDate.visibility = View.VISIBLE
                            binding.layoutData.visibility = View.VISIBLE
                            binding.editCat.isFocusable = false
                            rowCatDetailModel = it.rowCatDetail!!
                            binding.editCat.setText(rowCatDetailModel.cat)
                            binding.editDate.setText(rowCatDetailModel.date)
                            binding.editSKaWeight.setText(rowCatDetailModel.sKaWeight)
                            binding.editSToWeight.setText(rowCatDetailModel.sToWeight)
                            binding.editSoKaWeight.setText(rowCatDetailModel.soKaWeight)
                            binding.editSoToWeight.setText(rowCatDetailModel.soToWeight)
                            binding.editRowWeight.setText(rowCatDetailModel.rowWeight)
                            binding.editW1.setText(rowCatDetailModel.w1)
                            binding.editW2.setText(rowCatDetailModel.w2)
                            binding.editW3.setText(rowCatDetailModel.w3)
                            binding.editTotal.setText(rowCatDetailModel.total)
                            binding.editOtherHpOut.setText(rowCatDetailModel.otherOut)
                            binding.editAfterTotal.setText(rowCatDetailModel.afterTotal)
                            binding.editTotalNag.setText(rowCatDetailModel.totalStone)
                            binding.editTotalWeight.setText(rowCatDetailModel.totalWeight)
                            binding.editRowReady.setText(rowCatDetailModel.rowReady)
                            binding.editPalet.setText(rowCatDetailModel.plate)
                            try {

                            }catch (e:Exception){
                                FirebaseCrashlytics.getInstance().recordException(e)
                            }
                            progressBar.dismiss()
                        } else {
                            progressBar.dismiss()
                        }
                    }
            }
        }
    }
}