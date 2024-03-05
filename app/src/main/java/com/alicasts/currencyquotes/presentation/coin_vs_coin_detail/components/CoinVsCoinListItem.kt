package com.alicasts.currencyquotes.presentation.coin_vs_coin_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alicasts.currencyquotes.domain.model.CoinVsCoinListItemModel

@Composable
fun CoinVsCoinListItem(
    coinVsCoin: CoinVsCoinListItemModel,
    onItemClick: (CoinVsCoinListItemModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coinVsCoin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coinVsCoin.coinVsCoinTitle} (${coinVsCoin.coinVsCoinId})",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
    }
}