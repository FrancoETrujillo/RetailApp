package com.mvatech.ftrujillo.abfclone.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class ScopedViewModel:ViewModel(){
    private val viewModelJob = SupervisorJob()
    protected val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
}