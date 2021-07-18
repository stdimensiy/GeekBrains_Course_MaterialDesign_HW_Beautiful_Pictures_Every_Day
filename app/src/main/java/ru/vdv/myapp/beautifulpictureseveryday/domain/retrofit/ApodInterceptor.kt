package ru.vdv.myapp.beautifulpictureseveryday.domain.retrofit

import okhttp3.Interceptor
import java.io.IOException

class ApodInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        return chain.proceed(chain.request())
    }
}