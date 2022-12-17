package com.harsh.roughdiamondrate

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

public class Utility {

    companion object{

        fun getTextFromEditText(editText: EditText):String{
            return editText.text.toString().trim()
        }
        fun showToast(context: Context,message:String,duration:Int){
            Toast.makeText(context,message,duration).show()
        }
        suspend fun setSharedPreferences(activity: Context, Key: String, Value: String) {
            val sharedpreferences =
                activity.getSharedPreferences(activity.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor = sharedpreferences.edit()
            editor.putString(Key, Value)
            editor.apply()
        }
        fun getSharedPreferences(activity: Context, Key: String?): String? {
            val sharedpreferences = activity.getSharedPreferences(activity.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            return sharedpreferences.getString(Key, "")
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

        fun printLog(tag: String,message: String){
            if(BuildConfig.DEBUG){
                if(tag.isNotEmpty() && message.isNotEmpty()){
                    Log.e(tag,message)
                }
            }
        }

    }
}