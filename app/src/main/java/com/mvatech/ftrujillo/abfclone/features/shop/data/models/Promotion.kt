package com.mvatech.ftrujillo.abfclone.features.shop.data.models

data class Promotion(
    val img: String,
    val promotionContent: List<PromotionContent>,
    val disclaimer: String
)