package com.mvatech.ftrujillo.retailapp.core

import android.view.View
import android.view.animation.AnimationUtils
import com.mvatech.ftrujillo.retailapp.R

fun animateViewSlideFromRight(viewToAnimate: View) {
    if (viewToAnimate.animation == null) {
        val animId = R.anim.slide_from_right
        val animation = AnimationUtils.loadAnimation(viewToAnimate.context, animId)
        viewToAnimate.animation = animation
    }
}