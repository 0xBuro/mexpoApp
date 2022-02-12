package com.burakbo.mexpoapp.data

import com.burakbo.mexpoapp.data.remote.api.BitpandaApi
import com.burakbo.mexpoapp.data.remote.dto.BitpandaDto
import com.burakbo.mexpoapp.domain.repository.BitpandaCoinRepository
import javax.inject.Inject

class BitpandaCoinRepositoryImpl @Inject constructor(
    private val api: BitpandaApi
) : BitpandaCoinRepository {

    override suspend fun getBitpandaCoins(): List<BitpandaDto> {
        return listOf(api.getCoins())
    }
}