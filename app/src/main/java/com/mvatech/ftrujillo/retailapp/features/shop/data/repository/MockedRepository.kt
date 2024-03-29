package com.mvatech.ftrujillo.retailapp.features.shop.data.repository

import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.Promotion
import com.mvatech.ftrujillo.retailapp.features.shop.data.network.NetworkApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockedRepository(private val apiService: NetworkApiService) : Repository {

    private val mockData = MockDataGenerator()
    override fun getNewArrivalList(): List<NewArrival> {
        return mockData.getNewArrivalList(12)
    }

    override fun getClothingCategoryList(): List<ClothingCategory> {
        return mockData.getClothingCategoryList()
    }

    override fun getCollectionList(): List<ClothingCollection> {
        return mockData.getCollectionList()
    }

    override suspend fun getPromotionList(): List<Promotion> {
        return withContext(Dispatchers.IO) {
            val promoResponse = apiService.getPromotionList().await()
            val response = mutableListOf<Promotion>()
            if (promoResponse.isSuccessful) {
                promoResponse.body()?.let {
                    mockData.preparePromotionList(it)
                    response.addAll(it)
                }
            }
            return@withContext response
        }

    }

}