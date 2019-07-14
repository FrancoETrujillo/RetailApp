package com.mvatech.ftrujillo.retailapp.features.shop.data.models

data class Promotion(
    val title: String,
    var backgroundImage: String,
    val content: List<Content>?,
    val promoMessage: String?,
    val bottomDescription: String?,
    val topDescription: String?
)