package ru.vdv.myapp.beautifulpictureseveryday.domain.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    var retrofit: Retrofit? = null
    fun getClient(baseUrl: String): Retrofit {
        Log.i("Моя проверка", "клинет создан для $baseUrl")

        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient(ApodInterceptor()))
                .build()
        }
        Log.i("Моя проверка", "клинет создан$this")
        return retrofit!!
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }
}