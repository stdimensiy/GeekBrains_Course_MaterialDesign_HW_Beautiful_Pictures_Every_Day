package ru.vdv.myapp.beautifulpictureseveryday.domain

import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.api.RetrofitServicesNasa
import ru.vdv.myapp.beautifulpictureseveryday.domain.retrofit.RetrofitClient

object Common {
    val retrofitServicesNasa: RetrofitServicesNasa
        get() {
            return RetrofitClient.getClient(NasaSettingConstants.BASE_URL)
                .create(RetrofitServicesNasa::class.java)
        }
}