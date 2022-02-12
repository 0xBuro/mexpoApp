package com.burakbo.mexpoapp.presentation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list")
}