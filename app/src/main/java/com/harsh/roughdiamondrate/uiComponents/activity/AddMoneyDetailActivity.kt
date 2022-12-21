package com.harsh.roughdiamondrate.uiComponents.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View.OnFocusChangeListener
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityAddMoneyDetailBinding
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.AddMoneyDetailViewModel
import java.util.*

class AddMoneyDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddMoneyDetailBinding
    lateinit var viewModel: AddMoneyDetailViewModel
    lateinit var progressBar: Dialog

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

        viewModel.getResponseModel.observe(this) {
            Log.e("TAG", "onCreate: $it")
            Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
            if (it.Status.equals("1")) {
                progressBar.dismiss()
                binding.buttonSend.isEnabled = true
                resetEditText(binding.editDeposit)
                resetEditText(binding.editDepositNumber)
                resetEditText(binding.editWithdrawal)
                resetEditText(binding.editWithdrawalNumber)
                resetEditText(binding.editDetail)
                resetEditText(binding.editDate)
                resetEditText(binding.editPaltyName)
            }
        }




        binding.buttonSend.setOnClickListener {
            progressBar = ProgressBar.getDialog(this)
            progressBar.setCancelable(false)
            progressBar.show()
            binding.buttonSend.isEnabled = false
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