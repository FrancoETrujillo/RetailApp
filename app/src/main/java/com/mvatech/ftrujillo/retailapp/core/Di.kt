package com.mvatech.ftrujillo.retailapp.core

import com.mvatech.ftrujillo.retailapp.features.shop.data.network.NetworkApiService
import com.mvatech.ftrujillo.retailapp.features.shop.data.repository.MockedRepository
import com.mvatech.ftrujillo.retailapp.features.shop.data.repository.Repository
import com.mvatech.ftrujillo.retailapp.features.shop.viewmodels.CategoriesViewModel
import com.mvatech.ftrujillo.retailapp.features.shop.viewmodels.ExploreViewModel
import com.mvatech.ftrujillo.retailapp.features.shop.viewmodels.NewArrivalsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { NetworkApiService() }
    single<Repository>{MockedRepository(get())}
    viewModel { CategoriesViewModel(get()) }
    viewModel { ExploreViewModel(get()) }
    viewModel { NewArrivalsViewModel(get()) }
}