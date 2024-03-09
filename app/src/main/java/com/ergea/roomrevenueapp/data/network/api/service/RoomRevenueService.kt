package com.ergea.roomrevenueapp.data.network.api.service

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ergea.roomrevenueapp.BuildConfig
import com.ergea.roomrevenueapp.data.network.api.model.GetRoomRevenueResponse
import com.ergea.roomrevenueapp.data.network.api.model.RoomRevenueRequest
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface RoomRevenueService {

    @POST("VHPMobile3/rest/Report/mobileDev")
    suspend fun postRoomRevenue(@Body roomRevenueRequest: RoomRevenueRequest): GetRoomRevenueResponse

    companion object {
        @JvmStatic
        operator fun invoke(chucker: ChuckerInterceptor): RoomRevenueService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .addInterceptor(chucker)
                .addInterceptor {
                    val request = it.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("inputUserkey", "686EC892A74BC4A8031E2128A0E053EEEEAE1CA1")
                        .addHeader("inputUsername", "mimin")
                        .build()
                    return@addInterceptor it.proceed(request)
                }
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
            GsonBuilder().create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(RoomRevenueService::class.java)
        }
    }
}