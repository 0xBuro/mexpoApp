package com.burakbo.mexpoapp.data.remote.repository


import com.burakbo.mexpoapp.data.remote.api.BitpandaApi
import com.burakbo.mexpoapp.data.remote.dto.BitpandaDto
import com.burakbo.mexpoapp.data.remote.routes.HttpRoutes
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class BitpandaApiImpl(private val client: HttpClient)
    : BitpandaApi {
    override suspend fun getCoins(): BitpandaDto {
        return client.get {
            url(HttpRoutes.BitpandaHttpRoutes.wallets)
            contentType(ContentType.Application.Json)
            headers{
                header("X-API-KEY", HttpRoutes.BitpandaHttpRoutes.bitpandaApiKey)
            }
        }
    }
}