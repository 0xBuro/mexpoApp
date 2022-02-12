package com.burakbo.mexpoapp.data.remote.routes

import com.burakbo.mexpoapp.BuildConfig


object BitpandaHttpRoutes {

    private const val BASE_URL ="https://api.bitpanda.com/v1"
    const val wallets = "$BASE_URL/wallets"
    const val bitpandaApiKey = BuildConfig.bitpandaApiKey
}