package com.harsh.roughdiamondrate

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat

class Utility {

    companion object {

        fun getTextFromEditText(editText: EditText): String {
            return editText.text.toString().trim()
        }

        fun showToast(context: Context, message: String, duration: Int) {
            Toast.makeText(context, message, duration).show()
        }

        fun setSharedPreferences(activity: Context, Key: String, Value: String) {
            val sharedPreferences =
                activity.getSharedPreferences(
                    activity.resources.getString(R.string.app_name),
                    Context.MODE_PRIVATE
                )
            val editor = sharedPreferences.edit()
            editor.putString(Key, Value)
            editor.apply()
        }

        fun getSharedPreferences(activity: Context, Key: String?): String? {
            val sharedPreferences = activity.getSharedPreferences(
                activity.resources.getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
            return sharedPreferences.getString(Key, "")
        }

        fun hideKeyboard(activity: Activity) {
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            //Find the currently focused view, so we can grab the correct window token from it.
            var view = activity.currentFocus
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun printLog(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                if (tag.isNotEmpty() && message.isNotEmpty()) {
                    Log.e(tag, message)
                }
            }
        }

        fun CoroutineScope.launchIO(block: suspend (CoroutineScope) -> Unit) = this.launch(
            Dispatchers.IO
        ) {
            block(this)
        }

        fun resetEditText(editText: EditText) {
            editText.text.clear()
        }

        fun roundNumber(patten:String = "#.#",number:Double):Double{

            return if(patten.isNotEmpty()){

                val df = DecimalFormat(patten)
                df.roundingMode = RoundingMode.UP
                df.format(number).toDouble()

            }else{
                0.0;
            }
        }

    }
}