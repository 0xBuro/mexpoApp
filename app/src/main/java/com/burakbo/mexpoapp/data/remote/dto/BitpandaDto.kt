package com.burakbo.mexpoapp.data.remote.dto

import com.burakbo.mexpoapp.domain.model.BitpandaCoin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class BitpandaDto(
    val data: List<DataList>
)

@Serializable
data class DataList(
    @SerialName("type")
    val type: String,
    @SerialName("attributes")
    val attributes: ObjectList,
    @SerialName("id")
    val id: String
)

@Serializable
data class ObjectList(
    @SerialName("cryptocoin_id")
    val coin: String,
    @SerialName("cryptocoin_symbol")
    val symbol: String,
    @SerialName("balance")
    val balance: String,
    @SerialName("is_default")
    val default: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("pending_transactions_count")
    val pendingCount: Int,
    @SerialName("deleted")
    val deleted: Boolean,
    @SerialName("is_index")
    val indexed: Boolean
)


fun BitpandaDto.toBitpandaCoin(): BitpandaCoin {
    return BitpandaCoin(
        icon = data.map { it.attributes.symbol },
        symbol = data.map { it.attributes.symbol },
        balance = data.map { it.attributes.balance.toDouble() }
    )
}

