package com.mvatech.ftrujillo.abfclone.features.shop.data.models

data class Promotion(
    val title: String,
    val backgroundImage: String,
    val content: List<Content>?,
    val promoMessage: String?,
    val bottomDescription: String?,
    val topDescription: String?
)