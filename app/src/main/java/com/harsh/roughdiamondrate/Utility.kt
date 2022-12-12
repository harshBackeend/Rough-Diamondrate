package com.harsh.roughdiamondrate

import android.content.Context
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

    }
}