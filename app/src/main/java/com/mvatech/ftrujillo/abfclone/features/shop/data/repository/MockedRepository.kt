package com.mvatech.ftrujillo.abfclone.features.shop.data.repository

import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Promotion

class MockedRepository : Repository {

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

    override fun getPromotionList(): List<Promotion> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}