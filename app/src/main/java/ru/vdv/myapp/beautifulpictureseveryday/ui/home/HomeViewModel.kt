package ru.vdv.myapp.beautifulpictureseveryday.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vdv.myapp.beautifulpictureseveryday.R
import ru.vdv.myapp.beautifulpictureseveryday.domain.TestNasaRepository

class HomeViewModel(
    app: Application,
    private val repository: TestNasaRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = app.getString(R.string.home_fragment_default_text)
    }
    val text: LiveData<String> = _text
}