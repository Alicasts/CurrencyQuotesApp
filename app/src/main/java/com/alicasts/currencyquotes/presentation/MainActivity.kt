package com.alicasts.currencyquotes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alicasts.currencyquotes.presentation.coin_vs_coin_detail.CoinVsCoinDetailScreen
import com.alicasts.currencyquotes.presentation.coin_vs_coin_list.CoinVsCoinListScreen
import com.alicasts.currencyquotes.presentation.theme.CurrencyQuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyQuotesTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinVsCoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinVsCoinListScreen.route
                        ) {
                            CoinVsCoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinVsCoinDetailScreen.route + "/{coinVsCoinId}"
                        ) {
                            CoinVsCoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}