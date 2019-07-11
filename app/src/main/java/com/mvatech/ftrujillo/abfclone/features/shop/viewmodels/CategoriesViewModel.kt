package com.mvatech.ftrujillo.abfclone.features.shop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.categories_tab_wrappers.CategoriesCollectionsContent
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.categories_tab_wrappers.CategoriesNewArrivalsContent
import com.mvatech.ftrujillo.abfclone.features.shop.data.repository.MockedRepository
import com.mvatech.ftrujillo.abfclone.features.shop.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {
    private val repository:Repository = MockedRepository()
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _categoriesContent = MutableLiveData<List<Any>>()

    val getCategoriesContent:LiveData<List<Any>> = _categoriesContent

    private fun getNewArrivals() = CategoriesNewArrivalsContent(repository.getNewArrivalList())
    private fun getCategories() = repository.getClothingCategoryList()
    private fun getCollections() = CategoriesCollectionsContent(repository.getCollectionList())

    fun updateContent() {
        uiScope.launch(Dispatchers.IO){
            val contentReturn = mutableListOf<Any>()
            contentReturn.add(getNewArrivals())
            contentReturn.addAll(getCategories())
            contentReturn.add(getCollections())
            _categoriesContent.postValue(contentReturn)
        }
    }
}
