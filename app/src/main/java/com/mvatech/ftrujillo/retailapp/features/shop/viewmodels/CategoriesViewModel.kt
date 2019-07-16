package com.mvatech.ftrujillo.retailapp.features.shop.viewmodels

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.ScopedViewModel
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesNewArrivalsContent
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesSectionHeader
import com.mvatech.ftrujillo.retailapp.features.shop.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: Repository) : ScopedViewModel() {


    private val _categoriesContent = MutableLiveData<List<Any>>()

    val categoriesContent: LiveData<List<Any>> = _categoriesContent

    private fun getNewArrivals() = CategoriesNewArrivalsContent(repository.getNewArrivalList())
    private fun getCategories() = repository.getClothingCategoryList()
    private fun getCollections() = repository.getCollectionList()

    fun updateContent() {
        uiScope.launch(Dispatchers.IO) {
            val contentReturn = mutableListOf<Any>()
            contentReturn.add(CategoriesSectionHeader("NEW ARRIVALS"))
            contentReturn.add(getNewArrivals())
            contentReturn.addAll(getCategories())
            contentReturn.add(CategoriesSectionHeader("COLLECTIONS"))
            contentReturn.addAll(getCollections())
            _categoriesContent.postValue(contentReturn)
        }
    }

}
