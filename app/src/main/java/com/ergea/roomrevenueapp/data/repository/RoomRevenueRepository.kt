package com.ergea.roomrevenueapp.data.repository

import com.ergea.roomrevenueapp.data.network.api.model.RoomRevenueRequest
import com.ergea.roomrevenueapp.data.network.api.service.RoomRevenueService
import com.ergea.roomrevenueapp.domain.mapper.MapRoomRevenue.mapToEntityList
import com.ergea.roomrevenueapp.domain.model.RoomRevenue
import com.ergea.roomrevenueapp.utils.Resource
import com.ergea.roomrevenueapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow


interface RoomRevenueRepository {
    suspend fun postRoomRevenue(request: RoomRevenueRequest): Flow<Resource<List<RoomRevenue>>>
}

class RoomRevenueRepositoryImpl(private val service: RoomRevenueService) : RoomRevenueRepository {

    override suspend fun postRoomRevenue(request: RoomRevenueRequest): Flow<Resource<List<RoomRevenue>>> {
        return proceedFlow {
            service.postRoomRevenue(request).response?.clList?.mapToEntityList() ?: emptyList()
        }
    }
}