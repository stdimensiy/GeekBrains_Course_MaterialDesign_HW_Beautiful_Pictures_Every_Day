package ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces

import ru.vdv.myapp.beautifulpictureseveryday.domain.NasaApodResponse

interface BasicNasaRepository {
    // интерфейс взаимодействия с ресурсом NASA
    //API APOD  - возвращает картинку дня (на текущую дату)
    fun getApodForToday(
        nasaApiKey: String,
        thumbs: Boolean,
        callBack: CallBack<NasaApodResponse>
    )

    //API APOD  - возвращает картинку дня (на выбранную дату)
    fun getApodForDate(
        nasaApiKey: String,
        stringDate: String,
        thumbs: Boolean,
        callBack: CallBack<NasaApodResponse>
    )

    //API APOD  - возвращает коллекцию картинок дня за период
    fun getApodForPeriod(
        nasaApiKey: String,
        stringStartDate: String,
        stringEndDate: String,
        thumbs: Boolean,
        callBack: CallBack<List<NasaApodResponse>>
    )

    //API APOD  - возвращает коллекцию из (count) картинок дня но выбранных случайно
    fun getApodCountRandomlyChosen(
        nasaApiKey: String,
        count: Int,
        thumbs: Boolean,
        callBack: CallBack<List<NasaApodResponse>>
    )
}