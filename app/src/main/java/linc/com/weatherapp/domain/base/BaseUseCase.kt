package linc.com.weatherapp.domain.base

interface BaseUseCase<T, V> {
    suspend operator fun invoke(params: T): V
}