package com.harsh.roughdiamondrate

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import java.time.Duration

public class Utility {

    companion object{

        fun getTextFromEditText(editText: EditText):String{
            return editText.text.toString().trim()
        }
        fun showToast(context: Context,message:String,duration:Int){
            Toast.makeText(context,message,duration).show()
        }
    }
}