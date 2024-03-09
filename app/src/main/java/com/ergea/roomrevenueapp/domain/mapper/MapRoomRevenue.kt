package com.ergea.roomrevenueapp.domain.mapper

import com.ergea.roomrevenueapp.data.network.api.model.GetRoomRevenueResponse
import com.ergea.roomrevenueapp.domain.model.RoomRevenue
import com.ergea.roomrevenueapp.enum.TableTitle


object MapRoomRevenue {
    fun GetRoomRevenueResponse.Response.ClList.mapToEntityList() = listOf(
        RoomRevenue(
            TableTitle.ROOM,
            this.clList?.map { it?.zinr.toString().ifEmpty { "-" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.ARGT,
            this.clList?.map { it?.argt.toString().ifEmpty { "-" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.RCODE,
            this.clList?.map { it?.ratecode.toString().ifEmpty { "-" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.CURR,
            this.clList?.map { it?.currency.toString().ifEmpty { "-" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.ROOM_RATE,
            this.clList?.map { it?.zipreis.toString().ifEmpty { "0.0" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.PAX,
            this.clList?.map { it?.pax.toString().ifEmpty { "0" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.COMP,
            this.clList?.map { it?.com.toString().ifEmpty { "0" } } ?: emptyList()),
        RoomRevenue(
            TableTitle.ARRIVAL,
            this.clList?.map { it?.ankunft ?: "-" } ?: emptyList()),
        RoomRevenue(
            TableTitle.DEPART,
            this.clList?.map { it?.abreise ?: "-" } ?: emptyList()),
        RoomRevenue(
            TableTitle.GUEST_NAME,
            this.clList?.map { it?.name.toString().ifEmpty { "-" } } ?: emptyList()),
    )
}