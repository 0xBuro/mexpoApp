package com.burakbo.mexpoapp.presentation.coin_list.components

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.burakbo.mexpoapp.domain.model.BitpandaCoin
import okhttp3.internal.Util.indexOf
import java.math.BigDecimal

@Composable
fun CoinListItem(
    coin: BitpandaCoin,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        // iterate through coins
            for((index, balance) in coin.balance.withIndex())
                if(balance > 0)
                    Text(
                        text = coin.symbol[index] + " " + balance,
                        style = MaterialTheme.typography.h4,
                        overflow = TextOverflow.Ellipsis
                )
    }
}