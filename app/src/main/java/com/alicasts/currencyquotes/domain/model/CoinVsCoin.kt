package com.alicasts.currencyquotes.domain.model

import com.google.gson.annotations.SerializedName

data class CoinVsCoin(
    val name: String,
    val ask: String,
    val bid: String,
    val codeIn: String,
    val code: String,
    val createDate: String,
    val high: String,
    val low: String,
    val pctChange: String,
    val timestamp: String,
    val varBid: String
)