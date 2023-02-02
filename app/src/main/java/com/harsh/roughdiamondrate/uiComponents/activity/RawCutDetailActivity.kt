package com.harsh.roughdiamondrate.uiComponents.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View.OnFocusChangeListener
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityRawCutDetailBinding
import com.harsh.roughdiamondrate.model.ValidationModel
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.RawCutDetailViewModel
import java.util.*
import kotlin.math.roundToInt

class RawCutDetailActivity : AppCompatActivity() {
    /**
     * This use for bind xml file to java file.
     */
    private lateinit var binding: ActivityRawCutDetailBinding

    /**
     * This use for live calculation in this activity.
     */
    private lateinit var liveData: MutableLiveData<HashMap<String, Double>>
    private lateinit var progressBar: Dialog
    lateinit var viewModel: RawCutDetailViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[RawCutDetailViewModel::class.java]
        liveData = MutableLiveData<HashMap<String, Double>>()
        val hashMap = kotlin.collections.HashMap<String, Double>()

        hashMap["weight"] = 0.00
        hashMap["price"] = 0.00
        hashMap["dollarPrice"] = 0.00
        hashMap["brokeragePrice"] = 0.00
        hashMap["sellingPrice"] = 0.00
        hashMap["numberWeight"] = 0.00
        hashMap["numberPrice"] = 0.00
        hashMap["numberTotalPrice"] = 0.00

        binding.editDate.setOnClickListener {
            val c = Calendar.getInstance()
            val mYear = c[Calendar.YEAR]
            val mMonth = c[Calendar.MONTH]
            val mDay = c[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(
                this, { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    val day = if (dayOfMonth > 9) dayOfMonth.toString() else "0$dayOfMonth"
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

        binding.layoutDate.setOnClickListener {
            binding.editDate.performClick()
        }

        binding.weight.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.isNotEmpty()) {
                        hashMap["weight"] = p0.toString().toDouble()
                        liveData.postValue(hashMap)
                    }
                } catch (e: Exception) {

                }
            }
        })

        binding.price.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {

                    if (p0!!.isNotEmpty()) {
                        hashMap["price"] = p0.toString().toDouble()
                        liveData.postValue(hashMap)
                    }
                } catch (e: Exception) {

                }

            }
        })

        binding.dollarPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.isNotEmpty()) {
                        hashMap["dollarPrice"] = p0.toString().toDouble()
                        liveData.postValue(hashMap)
                    }
                } catch (e: Exception) {

                }

            }
        })

        binding.brokeragePrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.isNotEmpty()) {
                        hashMap["brokeragePrice"] = p0.toString().toDouble()
                        liveData.postValue(hashMap)
                    }
                } catch (e: Exception) {

                }


            }
        })

        binding.numberWeight.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.isNotEmpty()) {
                        hashMap["numberWeight"] = p0.toString().toDouble()
                        liveData.postValue(hashMap)
                    }
                } catch (e: Exception) {

                }


            }
        })

        binding.numberPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.isNotEmpty()) {
                        hashMap["numberPrice"] = p0.toString().toDouble()
                        liveData.postValue(hashMap)
                    }
                } catch (e: Exception) {

                }

            }
        })

        liveData.observe(this) {
            val constant = 100
            var secondSum = 0.00
            if (it["brokeragePrice"]!! > 0.00) {
                secondSum =
                    it["weight"]!! * it["price"]!! * it["dollarPrice"]!! * (it["brokeragePrice"]!! / constant)
            }
            if (secondSum > 0.00) {
                hashMap["sellingPrice"] =
                    it["weight"]!! * it["price"]!! * it["dollarPrice"]!! + secondSum.roundToInt()
                binding.sellingPrice.setText("${(it["weight"]!! * it["price"]!! * it["dollarPrice"]!! + secondSum).roundToInt()}")
            }

            if (it["weight"]!! > 0.00) {
                binding.totalPrice.setText("${(it["sellingPrice"]!! / it["weight"]!!).roundToInt()}")
                binding.numberPercentage.setText("${(it["numberWeight"]!! / (it["weight"]!! / constant)).roundToInt()}")
            }

            if (it["numberWeight"]!! > 0 && it["numberPrice"]!! > 0) {
                hashMap["numberTotalPrice"] = it["numberWeight"]!! * it["numberPrice"]!!
                binding.numberTotalPrice.setText("${(it["numberWeight"]!! * it["numberPrice"]!!).roundToInt()}")
            }

            if (it["weight"]!! > it["numberWeight"]!!) {
                binding.finalPrice.setText("${((it["sellingPrice"]!! - it["numberTotalPrice"]!!) / (it["weight"]!! - it["numberWeight"]!!)).roundToInt()}")
            }
        }

        binding.buttonSend.setOnClickListener {
            if (isValid()) {
                progressBar = ProgressBar.getDialog(this)
                progressBar.setCancelable(false)
                progressBar.show()
                binding.buttonSend.isEnabled = false
                viewModel.setDataToApi(
                    Utility.getTextFromEditText(binding.editDate),
                    Utility.getTextFromEditText(binding.mainKatNumber),
                    Utility.getTextFromEditText(binding.no),
                    Utility.getTextFromEditText(binding.katName),
                    Utility.getTextFromEditText(binding.maineWeight),
                    Utility.getTextFromEditText(binding.bag),
                    Utility.getTextFromEditText(binding.weight),
                    Utility.getTextFromEditText(binding.price),
                    Utility.getTextFromEditText(binding.dollarPrice),
                    Utility.getTextFromEditText(binding.brokeragePrice),
                    Utility.getTextFromEditText(binding.sellingPrice),
                    Utility.getTextFromEditText(binding.totalPrice),
                    Utility.getTextFromEditText(binding.numberWeight),
                    Utility.getTextFromEditText(binding.numberPrice),
                    Utility.getTextFromEditText(binding.numberPercentage),
                    Utility.getTextFromEditText(binding.numberTotalPrice),
                    Utility.getTextFromEditText(binding.finalPrice),
                    Utility.getTextFromEditText(binding.editDetail),
                    this
                ).observe(this) {
                    Log.e("TAG", "onCreate: $it")
                    Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                    if (it.Status == "1") {
                        progressBar.dismiss()
                        binding.buttonSend.isEnabled = true
                        Utility.resetEditText(binding.editDate)
                        Utility.resetEditText(binding.mainKatNumber)
                        Utility.resetEditText(binding.no)
                        Utility.resetEditText(binding.katName)
                        Utility.resetEditText(binding.maineWeight)
                        Utility.resetEditText(binding.bag)
                        Utility.resetEditText(binding.weight)
                        Utility.resetEditText(binding.price)
                        Utility.resetEditText(binding.dollarPrice)
                        Utility.resetEditText(binding.brokeragePrice)
                        Utility.resetEditText(binding.sellingPrice)
                        Utility.resetEditText(binding.totalPrice)
                        Utility.resetEditText(binding.numberWeight)
                        Utility.resetEditText(binding.numberPrice)
                        Utility.resetEditText(binding.numberPercentage)
                        Utility.resetEditText(binding.numberTotalPrice)
                        Utility.resetEditText(binding.finalPrice)
                        Utility.resetEditText(binding.editDetail)
                        finish()
                    } else {
                        progressBar.dismiss()
                        Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }

    private fun isValid(): Boolean {
        return if (Utility.getTextFromEditText(binding.editDate).isEmpty()) {
            Utility.showToast(this, ValidationModel.dateValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.mainKatNumber).isEmpty()) {
            Utility.showToast(this, ValidationModel.mainKatNumberValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.maineWeight).isEmpty()) {
            Utility.showToast(this, ValidationModel.maineWeightValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.bag).isEmpty()) {
            Utility.showToast(this, ValidationModel.bagValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.weight).isEmpty()) {
            Utility.showToast(this, ValidationModel.weightValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.price).isEmpty()) {
            Utility.showToast(this, ValidationModel.priceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.dollarPrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.dollarPriceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.brokeragePrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.brokeragePriceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.sellingPrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.sellingPriceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.totalPrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.totalPriceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.numberWeight).isEmpty()) {
            Utility.showToast(this, ValidationModel.numberWeightValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.numberPrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.numberPriceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.numberPercentage).isEmpty()) {
            Utility.showToast(this, ValidationModel.numberPercentageValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.numberTotalPrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.numberTotalPriceValidation, Toast.LENGTH_LONG)
            false
        } else if (Utility.getTextFromEditText(binding.finalPrice).isEmpty()) {
            Utility.showToast(this, ValidationModel.finalPriceValidation, Toast.LENGTH_LONG)
            false
        } else {
            true
        }
    }

}