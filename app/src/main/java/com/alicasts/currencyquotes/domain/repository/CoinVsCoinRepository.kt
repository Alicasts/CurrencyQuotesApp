package com.alicasts.currencyquotes.domain.repository

import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinDto
import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinListItemDto

interface CoinVsCoinRepository {

    suspend fun getCoinVsCoinList(): List<CoinVsCoinListItemDto>

    suspend fun getCoinVsCoinById(coinVsCoinId: String): CoinVsCoinDto
}