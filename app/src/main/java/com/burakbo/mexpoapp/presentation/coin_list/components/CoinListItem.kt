package com.burakbo.mexpoapp.presentation.coin_list.components

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.burakbo.mexpoapp.domain.model.BitpandaCoin

@Composable
fun CoinListItem(
    coin: BitpandaCoin,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.icon} ${coin.symbol} ${coin.balance}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}