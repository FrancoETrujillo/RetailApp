package com.mvatech.ftrujillo.abfclone.features.shop.viewmodels

import androidx.lifecycle.ViewModel;
import com.mvatech.ftrujillo.abfclone.features.shop.data.repository.MockedRepository
import com.mvatech.ftrujillo.abfclone.features.shop.data.repository.Repository

class CategoriesViewModel : ViewModel() {
    val repository:Repository = MockedRepository()

    fun getNewArrivals() = repository.getNewArrivalList()
}
