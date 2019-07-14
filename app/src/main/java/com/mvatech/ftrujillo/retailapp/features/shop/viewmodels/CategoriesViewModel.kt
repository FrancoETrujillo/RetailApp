package com.mvatech.ftrujillo.retailapp.features.shop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvatech.ftrujillo.retailapp.core.ScopedViewModel
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesCollectionsContent
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesNewArrivalsContent
import com.mvatech.ftrujillo.retailapp.features.shop.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: Repository) : ScopedViewModel() {


    private val _categoriesContent = MutableLiveData<List<Any>>()

    val categoriesContent: LiveData<List<Any>> = _categoriesContent

    private fun getNewArrivals() = CategoriesNewArrivalsContent(repository.getNewArrivalList())
    private fun getCategories() = repository.getClothingCategoryList()
    private fun getCollections() = CategoriesCollectionsContent(repository.getCollectionList())

    fun updateContent() {
        uiScope.launch(Dispatchers.IO) {
            val contentReturn = mutableListOf<Any>()
            contentReturn.add(getNewArrivals())
            contentReturn.addAll(getCategories())
            contentReturn.add(getCollections())
            _categoriesContent.postValue(contentReturn)
        }
    }

}
