package com.mvatech.ftrujillo.abfclone.features.shop.data.repository

import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Promotion
import com.mvatech.ftrujillo.abfclone.features.shop.data.network.NetworkApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

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
        Timber.d("Franco promotion list triggered")
        return withContext(Dispatchers.IO){
            val promoResponse = apiService.getPromotionList().await()
            if(promoResponse.isSuccessful) {
                Timber.d("Franco,  reposnse network %s", promoResponse.body())
            }else{
                Timber.d("Franco,  reposnse network %s", promoResponse.body())

            }
            return@withContext promoResponse.body()?: listOf()
        }

    }

}