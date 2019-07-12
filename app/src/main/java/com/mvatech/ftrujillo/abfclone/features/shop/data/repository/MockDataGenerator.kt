package com.mvatech.ftrujillo.abfclone.features.shop.data.repository

import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Promotion
import java.math.BigDecimal

class MockDataGenerator{
    fun getNewArrivalList(size: Int): List<NewArrival> {
        val list = mutableListOf<NewArrival>()
        val imageList = generateImageList(size)
        for ( i in 0 until size){
            list.add(NewArrival(
                i.toLong(),imageList[i] ,
                "Vacation Button-Up", BigDecimal(50),null, "Mens", "Getaway Essentials",
                "Trend Edit", "https://www.abercrombie.com/shop/us"
            ))
        }
        return list
    }

    private fun generateImageList(size: Int): List<String> {
        val mutableList = mutableListOf<String>()

        val imageList = listOf(
            "https://anf.scene7.com/is/image/anf/KIC_125-9421-1052-908_model1?\$product-ofp-anf-v1\$",
            "https://anf.scene7.com/is/image/anf/KIC_125-9421-1052-204_model1?\$product-ofp-anf-v1\$",
            "https://anf.scene7.com/is/image/anf/KIC_125-9421-1052-904_model1?\$product-ofp-anf-v1\$"
        )
        var count = 0
        for (i in 0 until size){
            if(count == imageList.size ) count = 0
            mutableList.add(imageList[count])
            count++
        }
        return mutableList
    }




    fun getClothingCategoryList(): List<ClothingCategory> {
        val list = mutableListOf<ClothingCategory>()
        for (i in 0 .. 6) {
            list.add(
                ClothingCategory(
                    "Tops",
                    "https://anf.scene7.com/is/image/anf/KIC_125-9519-1040-106_prod1?\$product-anf-v1\$&wid=800&hei=1000"
                )
            )

        }
        return list
    }

    fun getCollectionList(): List<ClothingCollection> {
        val list = mutableListOf<ClothingCollection>()
        for (i in 0 until 3) {
        list.add(
            ClothingCollection(
                "Pride Collection",
                "https://anf.scene7.com/is/image/anf/KIC_133-9175-0655-201_prod1?\$product-anf-v1\$&wid=800&hei=1000"
            )
        )
    }

        return list
    }

    fun getPromotionList(size: Int): List<Promotion> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}