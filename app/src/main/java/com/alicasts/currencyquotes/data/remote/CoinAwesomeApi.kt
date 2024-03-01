package com.alicasts.currencyquotes.data.remote

import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinDto
import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinListItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAwesomeApi {


    @GET("/xml/available")
    suspend fun getCoinVsCoinList(): List<CoinVsCoinListItemDto>

    @GET("/last/{coinVsCoinId}")
    suspend fun getCoinVsCoinLastQuoteById(@Path("coinVsCoinId") coinVsCoinId: String): CoinVsCoinDto
}