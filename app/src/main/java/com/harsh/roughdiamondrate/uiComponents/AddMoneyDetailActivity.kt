package com.harsh.roughdiamondrate.uiComponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityAddMoneyDetailBinding
import com.harsh.roughdiamondrate.viewModel.AddMoneyDetailViewModel

class AddMoneyDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddMoneyDetailBinding
    lateinit var viewModel: AddMoneyDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMoneyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AddMoneyDetailViewModel::class.java]


        binding.buttonSend.setOnClickListener {
            if (viewModel.setDataToApi(
                    Utility.getTextFromEditText(binding.editDate),
                    Utility.getTextFromEditText(binding.editPaltyName),
                    Utility.getTextFromEditText(binding.editDeposit),
                    Utility.getTextFromEditText(binding.editDepositNumber),
                    Utility.getTextFromEditText(binding.editWithdrawal),
                    Utility.getTextFromEditText(binding.editWithdrawalNumber),
                    Utility.getTextFromEditText(binding.editDetail),
                    this
                )
            ) {
                resetEditText(binding.editDate)
                resetEditText(binding.editPaltyName)
                resetEditText(binding.editDeposit)
                resetEditText(binding.editDepositNumber)
                resetEditText(binding.editWithdrawal)
                resetEditText(binding.editWithdrawalNumber)
                resetEditText(binding.editDetail)
            }
        }


    }

    private fun resetEditText(editText: EditText) {
        editText.text = null
    }
}