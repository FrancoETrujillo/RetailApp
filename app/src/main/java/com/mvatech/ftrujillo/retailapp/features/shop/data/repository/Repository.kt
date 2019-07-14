package com.mvatech.ftrujillo.retailapp.features.shop.data.repository

import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.Promotion

interface Repository {
    fun getNewArrivalList():List<NewArrival>
    fun getClothingCategoryList(): List<ClothingCategory>
    fun getCollectionList(): List<ClothingCollection>
    suspend fun getPromotionList(): List<Promotion>
}