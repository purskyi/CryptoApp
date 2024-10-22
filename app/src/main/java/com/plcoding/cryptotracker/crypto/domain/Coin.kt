package com.plcoding.cryptotracker.crypto.domain

import android.health.connect.datatypes.units.Percentage
import com.plcoding.cryptotracker.util.DomainError

data class Coin(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd:Double,
    val priceUsd: Double,
    val changePercentage24Hr: Double
)