package ru.vdv.myapp.beautifulpictureseveryday.domain

import com.google.gson.annotations.SerializedName

/**
 * Класс NasaApodResponse (создан для конфигурирования содержимого фрагмента "Картинка дня")
 * отвечает за хранение результатов ответов сервера NASA APOD (API) - Astronomy Picture of the Day
 * @param copyright ...... - Содержит имя автора (Владельца авторских прав на изображение)
 * @param date ........... - Содержит дату публикации снимка в формате ГГГГ-ММ-ДД
 * @param explanation .... - Содержит описание и пояснения для опубликованного снимка
 * @param hdUrl .......... - Ссылка на снимок в высоком разрешении
 * @param mediaType ...... - Содержит наименование типа объекта изображения (image / video )
 * @param serviceVersion . - Содержит текущую версию сервиса
 * @param thumbnailUrl ... - Содержит ссылку на миниатюру. Если APOD не является видео и если ключ
 *                           запроса thumbs = false или опущен, этот параметр игнорируется.
 * @param title .......... - Содержит строку заголовка (наименования) изображения
 * @param url ............ - Ссылка на снимок обычного разрешения (облегченный)
 * @constructor создает объект содержащий очередной ответ сервера NASA APOD (API)
 */
data class NasaApodResponse(
    @field:SerializedName("copyright")
    val copyright: String = "",
    @field:SerializedName("date")
    val date: String = "",
    @field:SerializedName("explanation")
    val explanation: String = "",
    @field:SerializedName("hdurl")
    val hdUrl: String = "",
    @field:SerializedName("media_type")
    val mediaType: String = "",
    @field:SerializedName("service_version")
    val serviceVersion: String = "",
    @field:SerializedName("thumbnail_url")
    val thumbnailUrl: String = "",
    @field:SerializedName("title")
    val title: String = "",
    @field:SerializedName("url")
    val url: String = ""
)
