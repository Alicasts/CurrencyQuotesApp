package com.alicasts.currencyquotes.presentation

sealed class Screen(val route: String) {
    object CoinVsCoinListScreen: Screen("coin_vs_coin_list_screen")
    object CoinVsCoinDetailScreen: Screen("coin_vs_coin_detail_screen")
}