package com.alicasts.currencyquotes.data.remote.dto

import com.alicasts.currencyquotes.domain.model.CoinVsCoinListItemModel

data class CoinVsCoinListItemDto(
    val coinVsCoinId: String,
    val coinVsCoinTitle: String
)

fun CoinVsCoinListItemDto.toCoinVsCoinListItem(): CoinVsCoinListItemModel {
    return CoinVsCoinListItemModel(
        coinVsCoinId = coinVsCoinId,
        coinVsCoinTitle = coinVsCoinTitle
    )
}