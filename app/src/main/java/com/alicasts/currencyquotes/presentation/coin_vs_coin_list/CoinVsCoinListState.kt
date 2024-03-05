package com.alicasts.currencyquotes.presentation.coin_vs_coin_list

import com.alicasts.currencyquotes.domain.model.CoinVsCoinListItem

data class CoinVsCoinListState(
    val isLoading: Boolean = false,
    val coinVsCoinList: List<CoinVsCoinListItem> = emptyList(),
    val error: String =""
)
