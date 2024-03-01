package com.alicasts.currencyquotes.data.remote.dto

import com.alicasts.currencyquotes.domain.model.CoinVsCoinListItem

data class CoinVsCoinListItemDto(
    val coinVsCoinId: String,
    val coinVsCoinTitle: String
)

fun CoinVsCoinListItemDto.toCoinVsCoinListItem(): CoinVsCoinListItem {
    return CoinVsCoinListItem(
        coinVsCoinId = coinVsCoinId,
        coinVsCoinTitle = coinVsCoinTitle
    )
}