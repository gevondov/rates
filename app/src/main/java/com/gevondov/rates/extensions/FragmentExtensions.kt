package com.gevondov.rates.extensions

import android.view.WindowManager
import androidx.fragment.app.Fragment

fun Fragment.makeStatusBarTransparent() {
    activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
}

fun Fragment.removeStatusBarTransparency() {
    activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
}
