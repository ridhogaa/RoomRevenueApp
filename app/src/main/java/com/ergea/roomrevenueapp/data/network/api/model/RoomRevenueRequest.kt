package com.ergea.roomrevenueapp.data.network.api.model

import com.google.gson.annotations.SerializedName

data class RoomRevenueRequest(
    @SerializedName("request")
    val request: Request
) {
    data class Request(
        @SerializedName("pvILanguage")
        val pvILanguage: Int,
        @SerializedName("newContrate")
        val newContrate: Boolean,
        @SerializedName("foreignRate")
        val foreignRate: Boolean,
        @SerializedName("priceDecimal")
        val priceDecimal: Int,
        @SerializedName("store")
        val store: Int,
        @SerializedName("currDate")
        val currDate: String
    )
}