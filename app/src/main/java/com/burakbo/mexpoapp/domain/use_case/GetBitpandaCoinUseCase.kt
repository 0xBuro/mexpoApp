package com.burakbo.mexpoapp.domain.use_case

import coil.network.HttpException
import com.burakbo.mexpoapp.common.Resource
import com.burakbo.mexpoapp.data.remote.dto.toBitpandaCoin
import com.burakbo.mexpoapp.domain.model.BitpandaCoin
import com.burakbo.mexpoapp.domain.repository.BitpandaCoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetBitpandaCoinUseCase @Inject constructor(
    private val repository: BitpandaCoinRepository
) {
    operator fun invoke(): Flow<Resource<List<BitpandaCoin>>> = flow {
        try {
            emit(Resource.Loading())
            val bitpandaCoins = repository.getBitpandaCoins().map{
                it.toBitpandaCoin()
            }
            emit(Resource.Success(bitpandaCoins))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Some unexpected Error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Server Error"))
        }
    }
}