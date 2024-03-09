package com.ergea.roomrevenueapp.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ergea.roomrevenueapp.data.network.api.service.RoomRevenueService
import com.ergea.roomrevenueapp.data.repository.RoomRevenueRepository
import com.ergea.roomrevenueapp.data.repository.RoomRevenueRepositoryImpl
import com.ergea.roomrevenueapp.domain.usecase.RoomRevenueUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import com.ergea.roomrevenueapp.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext


object AppModules {
    private val networkModule = module {
        single { ChuckerInterceptor(androidContext()) }
        single { RoomRevenueService(get()) }
    }

    private val repositoryModule = module {
        single<RoomRevenueRepository> { RoomRevenueRepositoryImpl(get()) }
    }

    private val useCaseModule = module {
        single<RoomRevenueUseCase> { RoomRevenueUseCase(get()) }
    }

    private val viewModelModule = module {
        viewModelOf(::MainViewModel)
    }

    val modules: List<Module> = listOf(
        networkModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}