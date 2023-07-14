package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeEnteryBinding
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.model.RawCutHistory
import com.harsh.roughdiamondrate.model.TaiyarVeList
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.TaiyarVeEnteryViewModel
import java.util.Calendar
import java.util.HashMap

class TaiyarVeEnteryActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaiyarVeEnteryBinding
    private val liveData by lazy { MutableLiveData<HashMap<String, Double>>() }
    private val hashMap = kotlin.collections.HashMap<String, Double>()
    lateinit var viewModel: TaiyarVeEnteryViewModel
    lateinit var progressBar: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaiyarVeEnteryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[TaiyarVeEnteryViewModel::class.java]

        hashMap["weight"] = 0.00
        hashMap["price"] = 0.00
        hashMap["percentage"] = 0.00
        hashMap["payment"] = 0.00
        hashMap["brokeragePercentage"] = 0.00

        val mainId = getTextFromIntent()

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

        binding.editDate.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                Utility.hideKeyboard(this)
                binding.editDate.performClick()
            }
        }

        binding.layoutDate.setOnClickListener {
            binding.editDate.performClick()
        }

        binding.editVeWeight.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.editVeWeight.setText("0.")
                        binding.editVeWeight.setSelection(Utility.getTextFromEditText(binding.editVeWeight).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["weight"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("weight", "$p0 ${e.message}")
                }
            }
        })

        binding.editPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.editPrice.setText("0.")
                        binding.editPrice.setSelection(Utility.getTextFromEditText(binding.editPrice).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["price"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("price", "$p0 ${e.message}")
                }
            }
        })

        binding.editPercentage.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.editPercentage.setText("0.")
                        binding.editPercentage.setSelection(Utility.getTextFromEditText(binding.editPercentage).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["percentage"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("percentage", "$p0 ${e.message}")
                }
            }
        })

        binding.editBrokeragePercentage.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.editBrokeragePercentage.setText("0.")
                        binding.editBrokeragePercentage.setSelection(
                            Utility.getTextFromEditText(
                                binding.editBrokeragePercentage
                            ).length
                        )
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["brokeragePercentage"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("brokeragePercentage", "$p0 ${e.message}")
                }
            }
        })

        liveData.observe(this) {
            val constant = 100

            var payment = 0.00
            var brokeragePrice = 0.00


            if (it["weight"]!! > 0.00 && it["price"]!! > 0.00 && it["percentage"]!! > 0.00) {
                val multiplication: Double = (it["weight"]!! * it["price"]!!)
                payment = Utility.roundNumber(
                    "#.#",
                    multiplication - multiplication * (it["percentage"]!! / constant)
                )
                hashMap["payment"] = payment
                binding.editPayment.setText(payment.toString())
            }

            if (payment > 0.00 && it["brokeragePercentage"]!! > 0.00) {
                brokeragePrice = payment * (it["brokeragePercentage"]!! / 100)
                binding.editBrokeragePrice.setText(
                    Utility.roundNumber("#.#", brokeragePrice).toString()
                )
            }

            if (payment > 0.00 && brokeragePrice > 0.00) {
                binding.editAfterBrokerage.setText(
                    Utility.roundNumber(
                        "#.#",
                        payment - brokeragePrice
                    ).toString()
                )
            }


            Utility.printLog("weight", "${it["weight"]}")
            Utility.printLog("price", "${it["price"]}")
            Utility.printLog("percentage", "${it["percentage"]}")
            Utility.printLog("brokeragePercentage", "${it["brokeragePercentage"]}")
            Utility.printLog("payment", payment.toString())
            Utility.printLog("brokeragePercentage", brokeragePrice.toString())
        }

        binding.buttonSend.setOnClickListener {
            progressBar = ProgressBar.getDialog(this)
            progressBar.setCancelable(false)
            progressBar.show()
            binding.buttonSend.isEnabled = false
            val rowId = mainId.ifEmpty {
                "0"
            }
            viewModel.addDataToTaiyarVe(
                Utility.getTextFromEditText(binding.editDate),
                Utility.getTextFromEditText(binding.editNo),
                Utility.getTextFromEditText(binding.editWeight),
                Utility.getTextFromEditText(binding.editVeWeight),
                Utility.getTextFromEditText(binding.editPrice),
                Utility.getTextFromEditText(binding.editPercentage),
                Utility.getTextFromEditText(binding.editPayment),
                Utility.getTextFromEditText(binding.editPerotti),
                Utility.getTextFromEditText(binding.editPaltyName),
                Utility.getTextFromEditText(binding.editBrokerName),
                Utility.getTextFromEditText(binding.editNumberDays),
                Utility.getTextFromEditText(binding.editCVDDiamond),
                Utility.getTextFromEditText(binding.editBrokeragePercentage),
                Utility.getTextFromEditText(binding.editBrokeragePrice),
                Utility.getTextFromEditText(binding.editAfterBrokerage),
                Utility.getTextFromEditText(binding.editPaymentDetail),
                Utility.getTextFromEditText(binding.editDetail),
                Utility.getTextFromEditText(binding.editOk),
                this,
                rowId = rowId
            ).observe(this) {
                Utility.printLog("TAG", "onCreate: $it")
                Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                if (it.Status == "1") {
                    progressBar.dismiss()
                    binding.buttonSend.isEnabled = true
                    Utility.resetEditText(binding.editDate)
                    Utility.resetEditText(binding.editNo)
                    Utility.resetEditText(binding.editWeight)
                    Utility.resetEditText(binding.editVeWeight)
                    Utility.resetEditText(binding.editPrice)
                    Utility.resetEditText(binding.editPercentage)
                    Utility.resetEditText(binding.editPayment)
                    Utility.resetEditText(binding.editPerotti)
                    Utility.resetEditText(binding.editPaltyName)
                    Utility.resetEditText(binding.editBrokerName)
                    Utility.resetEditText(binding.editNumberDays)
                    Utility.resetEditText(binding.editCVDDiamond)
                    Utility.resetEditText(binding.editBrokeragePercentage)
                    Utility.resetEditText(binding.editBrokeragePrice)
                    Utility.resetEditText(binding.editAfterBrokerage)
                    Utility.resetEditText(binding.editPaymentDetail)
                    Utility.resetEditText(binding.editDetail)
                    Utility.resetEditText(binding.editOk)
                    finish()
                } else {
                    progressBar.dismiss()
                    Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                }
            }

        }

    }

    private fun getTextFromIntent(): String {
        val rawCutHistory by lazy { MutableLiveData<TaiyarVeList>() }
        var rowId = ""
        try {
            rawCutHistory.postValue(intent.getSerializableExtra(IntentKey.taiyarDetail) as TaiyarVeList)

            rowId = intent.getStringExtra(IntentKey.rowId).toString()

            setDataToUri(rawCutHistory)

        } catch (e: Exception) {
            Utility.printLog("Error", "${e.message}")
        }
        return rowId
    }

    private fun setDataToUri(rawCutHistory: LiveData<TaiyarVeList>) {

        rawCutHistory.observe(this) {
            try {
                binding.editDate.setText(it.date)
                binding.editNo.setText(it.no)
                binding.editWeight.setText(it.weight)
                binding.editVeWeight.setText(it.veWeight)
                binding.editPrice.setText(it.price)
                binding.editPercentage.setText(it.percentage)
                binding.editPayment.setText(it.payment)
                binding.editPerotti.setText(it.peroti)
                binding.editPaltyName.setText(it.partyName)
                binding.editBrokerName.setText(it.brokerName)
                binding.editNumberDays.setText(it.numberOfDays)
                binding.editCVDDiamond.setText(it.cvdDiamond)
                binding.editBrokeragePercentage.setText(it.brokerageInPercentage)
                binding.editBrokeragePrice.setText(it.brokeragePrice)
                binding.editAfterBrokerage.setText(it.finalPrice)
                binding.editPaymentDetail.setText(it.paymentDetail)
                binding.editDetail.setText(it.detail)
                binding.editOk.setText(it.ok)
                try {
                    if (it.weight.toString().isNotEmpty()) {
                        hashMap["weight"] = it.weight.toString().toDouble()
                    }
                    if (it.price.toString().isNotEmpty()) {
                        hashMap["price"] = it.price.toString().toDouble()
                    }
                    if (it.percentage.toString().isNotEmpty()) {
                        hashMap["percentage"] = it.percentage.toString().toDouble()
                    }
                    if (it.payment.toString().isNotEmpty()) {
                        hashMap["payment"] = it.payment.toString().toDouble()
                    }
                    if (it.brokerageInPercentage.toString().isNotEmpty()) {
                        hashMap["brokeragePercentage"] = it.brokerageInPercentage.toString().toDouble()
                    }
                    liveData.postValue(hashMap)
                } catch (e: Exception) {
                    Utility.printLog("Error", "${e.message}")
                }

            } catch (e: Exception) {
                Utility.printLog("Error:", "${e.message}")
            }
        }
    }
}