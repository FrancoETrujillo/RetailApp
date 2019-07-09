package com.mvatech.ftrujillo.abfclone.features.shop.data.models

import java.math.BigDecimal

data class NewArrival(
    val id: Long,
    val image: String,
    val name: String,
    val price: BigDecimal,
    val discountedPrice: BigDecimal?,
    val bigCategory: String,// Men, Boys, etc
    val collection: String?, //getaway essentials
    val trendType: String?, // Trend edit
    val url: String
)