package com.mvatech.ftrujillo.abfclone.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes

fun Any.toast(context: Context?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this.toString(), duration).show()
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean): View {
    return LayoutInflater.from(context).inflate(resource, this, attachToRoot)
}