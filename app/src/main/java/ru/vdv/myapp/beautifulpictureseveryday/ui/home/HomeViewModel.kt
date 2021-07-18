package ru.vdv.myapp.beautifulpictureseveryday.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vdv.myapp.beautifulpictureseveryday.BuildConfig
import ru.vdv.myapp.beautifulpictureseveryday.domain.NasaApodResponse
import ru.vdv.myapp.beautifulpictureseveryday.domain.TestNasaRepository
import ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.CallBack

class HomeViewModel(
    app: Application,
    private val repository: TestNasaRepository
) : ViewModel() {
    val apiKey: String = BuildConfig.NASA_API_KEY
    var apodLiveData = MutableLiveData<NasaApodResponse>()

    fun fetchData() {
        Log.i("Моя проверка", "fetchData запущен")
        repository.getApodForToday(apiKey, true, object : CallBack<NasaApodResponse> {
            override fun onResult(value: NasaApodResponse) {
                apodLiveData.postValue(value)
                Log.i("Моя проверка", "Получен ответ")
            }
        })
    }
}