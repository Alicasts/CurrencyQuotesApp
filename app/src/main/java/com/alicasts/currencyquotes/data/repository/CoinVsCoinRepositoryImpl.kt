package com.alicasts.currencyquotes.data.repository

import com.alicasts.currencyquotes.data.remote.CoinAwesomeApi
import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinDto
import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinListItemDto
import com.alicasts.currencyquotes.domain.repository.CoinVsCoinRepository
import javax.inject.Inject

class CoinVsCoinRepositoryImpl @Inject constructor(
    private val api: CoinAwesomeApi
) : CoinVsCoinRepository {
    override suspend fun getCoinVsCoinList(): List<CoinVsCoinListItemDto> {
        val response = api.getCoinVsCoinList()
        return parseCoinVsCoinListResponse(response)
    }

    override suspend fun getCoinVsCoinById(coinVsCoinId: String): CoinVsCoinDto {
        val response = api.getCoinVsCoinLastQuoteById(coinVsCoinId)
        return parseCoinVsCoinDetailResponse(response)
    }

}