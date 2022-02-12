package com.burakbo.mexpoapp.data.remote.routes

import com.burakbo.mexpoapp.BuildConfig
import com.burakbo.mexpoapp.common.Constants.BITPANDA_BASE_URL

class HttpRoutes {

    object BitpandaHttpRoutes {

        private const val BASE_URL = BITPANDA_BASE_URL
        const val wallets = "$BASE_URL/wallets"
        const val bitpandaApiKey = BuildConfig.bitpandaApiKey
    }

    object KrakenHttpRoutes {
        private const val BASE_URL = "KRAKEN_BASE_URL"
        const val wallets = "$BASE_URL/KRAKEN_WALLET"
        const val krakenApiKey = "KRAKEN_API_KEY"
    }

}