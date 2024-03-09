package com.ergea.roomrevenueapp.domain.model

import com.ergea.roomrevenueapp.enum.TableTitle

data class RoomRevenue(
    val key: TableTitle,
    val value: List<String>
)