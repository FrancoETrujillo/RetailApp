package com.mvatech.ftrujillo.abfclone.features.shop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Promotion
import com.mvatech.ftrujillo.abfclone.features.shop.data.repository.Repository
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
