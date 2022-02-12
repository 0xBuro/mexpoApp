package com.burakbo.mexpoapp.presentation.coin_list

import com.burakbo.mexpoapp.domain.model.BitpandaCoin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<BitpandaCoin> = emptyList(),
    val error: String = ""
)
