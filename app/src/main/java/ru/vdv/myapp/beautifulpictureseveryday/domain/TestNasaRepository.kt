package ru.vdv.myapp.beautifulpictureseveryday.domain

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.BasicNasaRepository
import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.CallBack
import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.LocalRepository
import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.api.RetrofitServicesNasa

class TestNasaRepository : BasicNasaRepository, LocalRepository {
    private val networkServicesNasa: RetrofitServicesNasa = Common.retrofitServicesNasa

    override fun getApodForToday(
        nasaApiKey: String,
        thumbs: Boolean,
        callBack: CallBack<NasaApodResponse>
    ) {
        Log.i(
            "Моя проверка",
            "РЕПОЗИТОРИЙ getApodForToday запущен с nasaApiKey = $nasaApiKey b thumbs = $thumbs"
        )
        networkServicesNasa.getApodForToday(nasaApiKey, thumbs)
            .enqueue(object : Callback<NasaApodResponse> {
                override fun onResponse(
                    call: Call<NasaApodResponse>,
                    response: Response<NasaApodResponse>
                ) {
                    Log.i("Моя проверка", "РЕПОЗИТОРИЙ callBack = успех")
                    response.body()?.let { callBack.onResult(it) }
                }

                override fun onFailure(call: Call<NasaApodResponse>, t: Throwable) {
                    Log.i(
                        "Моя проверка",
                        "РЕПОЗИТОРИЙ callBack = неудача :-(" + call + "ffgfg" + t.localizedMessage
                    )
                    // Если провал (пока еще не придумал)
                }
            })
    }

    override fun getApodForDate(
        nasaApiKey: String,
        stringDate: String,
        thumbs: Boolean,
        callBack: CallBack<NasaApodResponse>
    ) {
        //TODO("Not yet implemented")
    }

    override fun getApodForPeriod(
        nasaApiKey: String,
        stringStartDate: String,
        stringEndDate: String,
        thumbs: Boolean,
        callBack: CallBack<List<NasaApodResponse>>
    ) {
        //TODO("Not yet implemented")
    }

    override fun getApodCountRandomlyChosen(
        nasaApiKey: String,
        count: Int,
        thumbs: Boolean,
        callBack: CallBack<List<NasaApodResponse>>
    ) {
        //TODO("Not yet implemented")
    }
    // Здесь будут готовиться данные для передачи во viewModel
}