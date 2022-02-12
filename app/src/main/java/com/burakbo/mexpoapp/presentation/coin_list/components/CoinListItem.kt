package com.burakbo.mexpoapp.presentation.coin_list.components

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.burakbo.mexpoapp.common.Constants.CRYPTO_ICON_URL
import com.burakbo.mexpoapp.domain.model.BitpandaCoin
import okhttp3.internal.Util.indexOf
import java.math.BigDecimal

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoinListItem(
    coin: BitpandaCoin,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        // iterate through coins with balance
            for((index, balance) in coin.balance.withIndex())
                if(balance > 0) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(CRYPTO_ICON_URL + coin.symbol[index].lowercase()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = coin.symbol[index] + "\n" + balance,
                            style = MaterialTheme.typography.body1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                }
    }
}