package com.burakbo.mexpoapp.data.remote

import com.burakbo.mexpoapp.BuildConfig


object HttpRoutes {

    private const val BASE_URL ="https://api.bitpanda.com/v1"
    const val wallets = "$BASE_URL/wallets"
    const val bitpandaApiKey = BuildConfig.bitpandaApiKey
}