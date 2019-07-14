package com.mvatech.ftrujillo.retailapp.features.shop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvatech.ftrujillo.retailapp.core.ScopedViewModel
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.Promotion
import com.mvatech.ftrujillo.retailapp.features.shop.data.repository.Repository
import kotlinx.coroutines.launch

class ExploreViewModel(private val repository: Repository) : ScopedViewModel() {
    private val _exploreContent = MutableLiveData<List<Promotion>>()

    val exploreContent: LiveData<List<Promotion>> = _exploreContent

    fun updateContent(){
        uiScope.launch {
            val response = repository.getPromotionList()
            _exploreContent.postValue(response)
        }
    }
}
