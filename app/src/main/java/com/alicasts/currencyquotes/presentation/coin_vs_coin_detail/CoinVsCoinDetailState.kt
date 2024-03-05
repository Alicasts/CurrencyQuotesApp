package com.alicasts.currencyquotes.presentation.coin_vs_coin_detail

import com.alicasts.currencyquotes.domain.model.CoinVsCoin

data class CoinVsCoinDetailState(
    val isLoading: Boolean = false,
    val coinVsCoin: CoinVsCoin? = null,
    val error: String =""
)
