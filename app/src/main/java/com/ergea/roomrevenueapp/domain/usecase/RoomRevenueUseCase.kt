package com.ergea.roomrevenueapp.domain.usecase

import com.ergea.roomrevenueapp.data.network.api.model.RoomRevenueRequest
import com.ergea.roomrevenueapp.data.repository.RoomRevenueRepository


class RoomRevenueUseCase(private val repository: RoomRevenueRepository) {
    suspend operator fun invoke(request: RoomRevenueRequest) =
        repository.postRoomRevenue(request)
}