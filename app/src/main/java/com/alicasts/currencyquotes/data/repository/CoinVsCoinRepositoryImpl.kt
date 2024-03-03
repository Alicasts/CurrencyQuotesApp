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
        return api.getCoinVsCoinList()
    }

    override suspend fun getCoinVsCoinById(coinVsCoinId: String): CoinVsCoinDto {
        return  api.getCoinVsCoinLastQuoteById(coinVsCoinId)
    }


}