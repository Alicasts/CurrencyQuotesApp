package com.alicasts.currencyquotes.di

import com.alicasts.currencyquotes.common.Constants
import com.alicasts.currencyquotes.data.remote.CoinAwesomeApi
import com.alicasts.currencyquotes.data.repository.CoinVsCoinRepositoryImpl
import com.alicasts.currencyquotes.domain.repository.CoinVsCoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinAwesomeApi(): CoinAwesomeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(CoinAwesomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinVsCoinRepository(api: CoinAwesomeApi): CoinVsCoinRepository {
        return CoinVsCoinRepositoryImpl(api)
    }
}