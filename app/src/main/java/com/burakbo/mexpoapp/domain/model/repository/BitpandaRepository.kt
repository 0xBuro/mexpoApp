package com.burakbo.mexpoapp.domain.model.repository

import com.burakbo.mexpoapp.data.remote.dto.BitpandaDto

interface BitpandaRepository {

    suspend fun getBitpandaCoins(): List<BitpandaDto>
}