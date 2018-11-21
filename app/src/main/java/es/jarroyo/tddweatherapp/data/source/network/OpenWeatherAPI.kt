package es.jarroyo.tddweatherapp.data.source.network

import es.jarroyo.tddweatherapp.BuildConfig
import es.jarroyo.tddweatherapp.domain.model.currentWeather.CurrentWeather
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {
    companion object {
        // PATH
        const val URL_PATH_CURRENT_WEATHER = "/data/2.5/weather"

        // PARAMETERS
        const val URL_PARAMETER_CITY_ID = "id"
        const val URL_PARAMETER_LICENSE_TOKEN = "APPID"
    }


    /**
     * CURRENT WEATHER
     */
    @GET(OpenWeatherAPI.URL_PATH_CURRENT_WEATHER)
    fun currentWeather(
        @Query(URL_PARAMETER_CITY_ID) id: String = "",
        @Query(URL_PARAMETER_LICENSE_TOKEN) appId: String = BuildConfig.OPEN_WEATHER_API_KEY
    ): Deferred<CurrentWeather>
}