package ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces

interface CallBack<T> {
    fun onResult(value: T)
}
