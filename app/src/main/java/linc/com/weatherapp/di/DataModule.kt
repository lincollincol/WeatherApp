package linc.com.weatherapp.di

import linc.com.weatherapp.data.network.ForecastApi
import linc.com.weatherapp.data.repository.ForecastRepositoryImpl
import linc.com.weatherapp.domain.repositories.ForecastRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single<Retrofit> { provideRetrofit() }
    factory<ForecastApi> { provideForecastApi(retrofit = get()) }
}

val repositoryModule = module {
    factory <ForecastRepository> { ForecastRepositoryImpl(forecastApi = get()) }
}

fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
//    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl("https://api.openweathermap.org")
    .build()

fun provideForecastApi(retrofit: Retrofit): ForecastApi =
    retrofit.create(ForecastApi::class.java)
