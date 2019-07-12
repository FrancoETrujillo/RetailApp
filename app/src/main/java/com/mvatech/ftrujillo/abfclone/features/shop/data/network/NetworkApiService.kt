package com.mvatech.ftrujillo.abfclone.features.shop.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mvatech.ftrujillo.abfclone.BuildConfig
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Promotion
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import timber.log.Timber
import java.util.concurrent.TimeUnit


interface NetworkApiService {
    @Headers("Accept: application/json", "User-Agent: Mozilla/5.0")
    @GET(BuildConfig.PROMOTIONS_PATH)
    fun getPromotionList(): Deferred<Response<List<Promotion>>>

    companion object {
        operator fun invoke(): NetworkApiService {
            Timber.d("Franco network invoked")

            val interceptor = Interceptor{chain ->
                val original = chain.request()
                val request =original.newBuilder().build()
                chain.proceed(request)
            }



            val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkApiService::class.java)
        }

    }
}

