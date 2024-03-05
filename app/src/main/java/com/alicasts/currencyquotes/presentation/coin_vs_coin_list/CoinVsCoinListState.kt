package com.alicasts.currencyquotes.presentation.coin_vs_coin_list

import com.alicasts.currencyquotes.domain.model.CoinVsCoinListItemModel

data class CoinVsCoinListState(
    val isLoading: Boolean = false,
    val coinVsCoinList: List<CoinVsCoinListItemModel> = emptyList(),
    val error: String =""
)
