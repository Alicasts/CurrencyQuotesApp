package com.alicasts.currencyquotes.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAwesomeApi {

    @GET("/json/available")
    suspend fun getCoinVsCoinList(): String

    @GET("/last/{coinVsCoinId}")
    suspend fun getCoinVsCoinLastQuoteById(@Path("coinVsCoinId") coinVsCoinId: String): String
}