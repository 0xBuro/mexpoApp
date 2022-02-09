package com.burakbo.mexpoapp.data.remote.api

import com.burakbo.mexpoapp.data.remote.repository.BitpandaApiImpl
import com.burakbo.mexpoapp.data.remote.dto.BitpandaDto
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface BitpandaApi {
    suspend fun getCoins(): BitpandaDto

    companion object {
        fun create(): BitpandaApi {
            return BitpandaApiImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}