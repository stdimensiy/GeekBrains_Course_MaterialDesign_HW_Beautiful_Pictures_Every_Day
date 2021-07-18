package ru.vdv.myapp.beautifulpictureseveryday.domain.interfaces.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.vdv.myapp.beautifulpictureseveryday.domain.NasaApodResponse

interface RetrofitServicesNasa {
    /**
     * APOD API
     * Режим: Общие данные и параметры запросов
     * @param date ....... - формат (YYYY-MM-DD). Дата запрашиваемой картинки дня (по умолчанию текущая дата)
     * @param start_date . - формат (YYYY-MM-DD). Начальная дата наборка картинок за период, нельзя
     *                       использовать совсместно с параметром "data", должна быть меньше
     *                       или равна текущей дате.
     * @param end_date ... - формат (YYYY-MM-DD). Конечная дата наборка картинок за период, нельзя
     *                       использовать совсместно с параметром "data". Должна быть меньше
     *                       или равна текущей дате и больше либо равна начальной дате.
     * @param count ...... - тип (Int), целое число равное количеству случайно выбранных картинок
     *                       дня в выборке. Нельзя использовать совместно спараметрами "date",
     *                       "start_date" и "end_date"
     * @param thumbs ..... - ип (Bool), флаг. При значении равном "true" объекты APOD не являющиеся
     *                       картинками (например видео) дополняются ссылкой на миниатюру.
     *                       по умолчанию = False
     * @param api_key .... - ключ пользовател (ну или демо)
     */

    /**
     * APOD API
     * Режим: getApodForToday - самый простой
     * параметры запросов описаны в общей части
     * @return возвращает объект "картинку дня" (сегодняшнего)...
     */
    @GET("planetary/apod")
    fun getApodForToday(
        @Query("api_key") nasaApiKey: String,
        @Query("thumbs") thumbs: Boolean,
    ): Call<NasaApodResponse>

    /**
     * APOD API
     * Режим: getApodForDate - запрос картинки дня на конкретную дату
     * параметры запросов описаны в общей части
     * @return возвращает объект "картинку дня" (на указанную дату)...
     */
    @GET("planetary/apod")
    fun getApodForDate(
        @Query("api_key") nasaApiKey: String,
        @Query("date") stringDate: String,
        @Query("thumbs") thumbs: Boolean,
    ): Call<NasaApodResponse>

    /**
     * APOD API
     * Режим: getApodForPeriod - набор картинок за конкретный период
     * параметры запросов описаны в общей части
     * @return возвращает объект "картинку дня" (на указанную дату)...
     */
    @GET("planetary/apod")
    fun getApodForPeriod(
        @Query("api_key") nasaApiKey: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("thumbs") thumbs: Boolean,
    ): Call<List<NasaApodResponse>>

}