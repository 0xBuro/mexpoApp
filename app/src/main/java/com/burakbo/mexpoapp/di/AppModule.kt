package com.burakbo.mexpoapp.di

import com.burakbo.mexpoapp.data.BitpandaCoinRepositoryImpl
import com.burakbo.mexpoapp.data.remote.api.BitpandaApi
import com.burakbo.mexpoapp.domain.repository.BitpandaCoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBitpandaCoinApi(): BitpandaApi {
        return BitpandaApi.create()
    }

    @Provides
    @Singleton
    fun provideBitpandaCoinRepository(api: BitpandaApi): BitpandaCoinRepository {
        return BitpandaCoinRepositoryImpl(api)
    }
}