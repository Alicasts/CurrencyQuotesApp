package com.alicasts.currencyquotes.data.repository

import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinDto
import com.alicasts.currencyquotes.data.remote.dto.CoinVsCoinListItemDto
import org.json.JSONObject

fun parseCoinVsCoinListResponse(response: String): List<CoinVsCoinListItemDto> {
    val reader = JSONObject(response)
    val keys = reader.keys()
    val coinVsCoinList = mutableListOf<CoinVsCoinListItemDto>()
    while (keys.hasNext()) {
        val key = keys.next()
        val value = reader.getString(key)
        coinVsCoinList.add(CoinVsCoinListItemDto(key, value))
    }
    return coinVsCoinList
}

fun parseCoinVsCoinDetailResponse(response: String): CoinVsCoinDto {
    val jsonObject = JSONObject(response)
    val currencyPairResponseKey = jsonObject.keys().next()
    val currencyPairResponse = jsonObject.getJSONObject(currencyPairResponseKey)

    return CoinVsCoinDto(
        ask = currencyPairResponse.getString("ask"),
        bid = currencyPairResponse.getString("bid"),
        code = currencyPairResponse.getString("code"),
        codeIn = currencyPairResponse.getString("codein"),
        createDate = currencyPairResponse.getString("create_date"),
        high = currencyPairResponse.getString("high"),
        low = currencyPairResponse.getString("low"),
        name = currencyPairResponse.getString("name"),
        pctChange = currencyPairResponse.getString("pctChange"),
        timestamp = currencyPairResponse.getString("timestamp"),
        varBid = currencyPairResponse.getString("varBid")
    )
}