package es.jarroyo.tddweatherapp.app.di.module

import dagger.Module
import dagger.Provides
import es.jarroyo.tddweatherapp.data.mapper.location.WeatherLocationEntitytoWeatherLocationMapper
import es.jarroyo.tddweatherapp.data.mapper.location.WeatherLocationToWeatherLocationEntityMapper
import es.jarroyo.tddweatherapp.data.repository.LocationRepository
import es.jarroyo.tddweatherapp.data.repository.WeatherRepository
import es.jarroyo.tddweatherapp.data.source.disk.DiskDataSource
import es.jarroyo.tddweatherapp.data.source.network.INetworkDataSource
import es.jarroyo.tddweatherapp.ui.App
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideForecastRepository(
        networkDataSource: INetworkDataSource,
        diskDataSource: DiskDataSource
    ) = WeatherRepository(networkDataSource, diskDataSource)

    @Provides
    @Singleton
    fun provideLocationRepository(
        app: App,
        diskDataSource: DiskDataSource,
        weatherLocationToWeatherLocationEntityMapper: WeatherLocationToWeatherLocationEntityMapper,
        weatherLocationEntitytoWeatherLocationMapper: WeatherLocationEntitytoWeatherLocationMapper
    ) = LocationRepository(app, diskDataSource, weatherLocationToWeatherLocationEntityMapper, weatherLocationEntitytoWeatherLocationMapper)
}