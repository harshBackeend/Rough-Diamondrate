package com.harsh.roughdiamondrate.uiComponents.commanUiView

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.databinding.LoaderLayoutBinding

class ProgressBar {
    companion object{

        fun getDialog(activity: Activity): Dialog {
            val loaderLayoutBinding = LoaderLayoutBinding.inflate(activity.layoutInflater)
            val view: View = loaderLayoutBinding.root
            val dialog1 = Dialog(activity)
            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog1.setContentView(view)
            dialog1.window!!.setDimAmount(0.5f)
            dialog1.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val paramsdialog: ViewGroup.LayoutParams = dialog1.window!!.attributes
            paramsdialog.width = RelativeLayout.LayoutParams.MATCH_PARENT
            paramsdialog.height = RelativeLayout.LayoutParams.MATCH_PARENT
            dialog1.window!!.setWindowAnimations(R.style.DialogTheme)
            dialog1.window!!.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            Glide.with(activity.baseContext).load(R.drawable.progres_bar).into(loaderLayoutBinding.progressBar)

            return dialog1
        }
    }


}