package com.alicasts.currencyquotes.data.remote.dto

import com.alicasts.currencyquotes.domain.model.CoinVsCoin
import com.google.gson.annotations.SerializedName

data class CoinVsCoinDto(
    val ask: String,
    val bid: String,
    val code: String,
    @SerializedName("codein")
    val codeIn: String,
    @SerializedName("create_date")
    val createDate: String,
    val high: String,
    val low: String,
    val name: String,
    val pctChange: String,
    val timestamp: String,
    val varBid: String
)

fun CoinVsCoinDto.toCoinVsCoin(): CoinVsCoin {
    return CoinVsCoin(
        ask = ask,
        bid = bid,
        code = code,
        codeIn = codeIn,
        createDate = createDate,
        high = high,
        low = low,
        name = name,
        pctChange = pctChange,
        timestamp = timestamp,
        varBid = varBid
    )
}