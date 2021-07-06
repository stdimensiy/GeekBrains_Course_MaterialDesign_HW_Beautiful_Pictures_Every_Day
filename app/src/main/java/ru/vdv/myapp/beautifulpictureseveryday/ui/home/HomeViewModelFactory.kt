package ru.vdv.myapp.beautifulpictureseveryday.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.vdv.myapp.beautifulpictureseveryday.domain.TestNasaRepository

class HomeViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        HomeViewModel(application, TestNasaRepository()) as T
}