package com.mvatech.ftrujillo.retailapp.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

fun Any.toast(context: Context?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this.toString(), duration).show()
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resource, this, attachToRoot)
}

fun BigDecimal.toCurrencyString(): String {
    val quantity = this.setScale(2, RoundingMode.FLOOR)
    val builder = StringBuilder()
    builder.apply {
        append('$')
        append(quantity.toBigInteger().toInt() )
        val fraction = quantity.remainder(BigDecimal.ONE).movePointRight(quantity.scale()).abs().toBigIntegerExact()
        if (!fraction == BigInteger.ZERO) append(fraction)
    }
    return builder.toString()
}

