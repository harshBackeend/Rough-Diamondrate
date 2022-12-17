package com.harsh.roughdiamondrate.uiComponents

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View.OnFocusChangeListener
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityAddMoneyDetailBinding
import com.harsh.roughdiamondrate.viewModel.AddMoneyDetailViewModel
import java.util.*

class AddMoneyDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddMoneyDetailBinding
    lateinit var viewModel: AddMoneyDetailViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMoneyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AddMoneyDetailViewModel::class.java]

        binding.editDate.setOnClickListener {
            val c = Calendar.getInstance()
            val mYear = c[Calendar.YEAR]
            val mMonth = c[Calendar.MONTH]
            val mDay = c[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(
                this, { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    val day =
                        if (dayOfMonth > 9) dayOfMonth.toString() else "0$dayOfMonth"
                    val month =
                        if (monthOfYear + 1 > 9) (monthOfYear + 1).toString() else "0" + (monthOfYear + 1)
                    binding.editDate.setText("$day/$month/$year")
                }, mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }

        binding.editDate.inputType = InputType.TYPE_NULL
        binding.editDate.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                Utility.hideKeyboard(this)
                binding.editDate.performClick()
            }
        }

        viewModel.getData.observe(this) {
            Log.e("TAG", "onCreate: $it", )
            if (it) {
                resetEditText(binding.editDate)
                resetEditText(binding.editPaltyName)
                resetEditText(binding.editDeposit)
                resetEditText(binding.editDepositNumber)
                resetEditText(binding.editWithdrawal)
                resetEditText(binding.editWithdrawalNumber)
                resetEditText(binding.editDetail)
            } else {

            }
        }




        binding.buttonSend.setOnClickListener {
            viewModel.setDataToApi(
                Utility.getTextFromEditText(binding.editDate),
                Utility.getTextFromEditText(binding.editPaltyName),
                Utility.getTextFromEditText(binding.editDeposit),
                Utility.getTextFromEditText(binding.editDepositNumber),
                Utility.getTextFromEditText(binding.editWithdrawal),
                Utility.getTextFromEditText(binding.editWithdrawalNumber),
                Utility.getTextFromEditText(binding.editDetail),
                this
            )
        }


    }

    private fun resetEditText(editText: EditText) {
        editText.text.clear()
    }
}