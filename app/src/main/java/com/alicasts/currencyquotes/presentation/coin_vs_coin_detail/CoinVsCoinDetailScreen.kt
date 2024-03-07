package com.alicasts.currencyquotes.presentation.coin_vs_coin_detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinVsCoinDetailScreen(
    viewModel: CoinVsCoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        state.coinVsCoin?.let { coinVsCoin ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = " ${coinVsCoin.name} (${coinVsCoin.codeIn})",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.weight(8f)
                        )

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CoinProvisoryText(param = coinVsCoin.name)
                        CoinProvisoryText(param = coinVsCoin.codeIn)
                        CoinProvisoryText(param = coinVsCoin.ask)
                        CoinProvisoryText(param = coinVsCoin.bid)
                        CoinProvisoryText(param = coinVsCoin.createDate)
                        CoinProvisoryText(param = coinVsCoin.high)
                        CoinProvisoryText(param = coinVsCoin.low)
                        CoinProvisoryText(param = coinVsCoin.pctChange)
                        CoinProvisoryText(param = coinVsCoin.timestamp)
                        CoinProvisoryText(param = coinVsCoin.varBid)
                    }

                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun CoinProvisoryText(
    param: String
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Blue,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = param,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}