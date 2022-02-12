package com.burakbo.mexpoapp.domain.repository

import com.burakbo.mexpoapp.data.remote.dto.BitpandaDto

interface BitpandaCoinRepository {

    suspend fun getBitpandaCoins(): List<BitpandaDto>
}