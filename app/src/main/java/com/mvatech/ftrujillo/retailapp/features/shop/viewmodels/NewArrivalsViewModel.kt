package com.mvatech.ftrujillo.retailapp.features.shop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvatech.ftrujillo.retailapp.core.ScopedViewModel
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.retailapp.features.shop.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewArrivalsViewModel(private val repository: Repository) : ScopedViewModel() {

    private val _newArrivalsList = MutableLiveData<List<NewArrival>>()

    val newArrivalsContent: LiveData<List<NewArrival>> = _newArrivalsList

    fun updateData() {
        uiScope.launch(Dispatchers.IO) {
            _newArrivalsList.postValue(repository.getNewArrivalList())
        }
    }
}
