package com.ergea.roomrevenueapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ergea.roomrevenueapp.data.network.api.model.RoomRevenueRequest
import com.ergea.roomrevenueapp.data.repository.RoomRevenueRepository
import com.ergea.roomrevenueapp.domain.model.RoomRevenue
import com.ergea.roomrevenueapp.domain.usecase.RoomRevenueUseCase
import com.ergea.roomrevenueapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainViewModel(private val useCase: RoomRevenueUseCase) : ViewModel() {

    private val _response = MutableLiveData<Resource<List<RoomRevenue>>>()
    val response: LiveData<Resource<List<RoomRevenue>>> = _response

    fun postRoomRevenue(request: RoomRevenueRequest) = viewModelScope.launch(Dispatchers.IO) {
        useCase(request).collectLatest { data ->
            _response.postValue(data)
        }
    }

}