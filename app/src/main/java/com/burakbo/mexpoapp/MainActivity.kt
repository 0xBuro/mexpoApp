package com.burakbo.mexpoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.imageLoader
import com.burakbo.mexpoapp.data.remote.api.BitpandaApi
import com.burakbo.mexpoapp.data.remote.dto.BitpandaDto
import com.burakbo.mexpoapp.ui.theme.MexpoAppTheme


class MainActivity : ComponentActivity() {

    private val service = BitpandaApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coins = produceState<List<BitpandaDto>>(
                initialValue = emptyList(),
                producer = {
                    value = listOf(service.getCoins())
                }
            )
            MexpoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) { LazyColumn {
                    items(coins.value) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            for(item in it.data)
                                if(item.attributes.balance.toDouble() > 0)
                                    Text(text = item.attributes.symbol + " " + item.attributes.balance)
                            CoilImg()
                        }

                    }

                }

                }
            }
        }
    }
}

@Composable
fun CoilImg() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(50.dp),
        contentAlignment = Alignment.Center
        ) {
        val painter = rememberImagePainter(
            data = "https://cryptologos.cc/logos/sushiswap-sushi-logo.png?v=018",
            builder = {}
        )
        Image(painter = painter, contentDescription = "Sushi")
    }
}