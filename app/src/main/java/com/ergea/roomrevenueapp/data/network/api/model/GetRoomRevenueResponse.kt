package com.ergea.roomrevenueapp.data.network.api.model

import com.google.gson.annotations.SerializedName

data class GetRoomRevenueResponse(
    @SerializedName("response")
    val response: Response?
) {
    data class Response(
        @SerializedName("outputOkFlag")
        val outputOkFlag: String?,
        @SerializedName("msgStr")
        val msgStr: String?,
        @SerializedName("msgWarning")
        val msgWarning: String?,
        @SerializedName("clList")
        val clList: ClList?,
        @SerializedName("currencyList")
        val currencyList: CurrencyList?,
        @SerializedName("sumList")
        val sumList: SumList?,
        @SerializedName("sList")
        val sList: SList?
    ) {
        data class ClList(
            @SerializedName("cl-list")
            val clList: List<Cl?>?
        ) {
            data class Cl(
                @SerializedName("zipreis")
                val zipreis: Double?,
                @SerializedName("localrate")
                val localrate: Double?,
                @SerializedName("lodging")
                val lodging: Double?,
                @SerializedName("bfast")
                val bfast: Double?,
                @SerializedName("lunch")
                val lunch: Double?,
                @SerializedName("dinner")
                val dinner: Double?,
                @SerializedName("misc")
                val misc: Double?,
                @SerializedName("fixcost")
                val fixcost: Double?,
                @SerializedName("t-rev")
                val tRev: Double?,
                @SerializedName("c-zipreis")
                val cZipreis: String?,
                @SerializedName("c-localrate")
                val cLocalrate: String?,
                @SerializedName("c-lodging")
                val cLodging: String?,
                @SerializedName("c-bfast")
                val cBfast: String?,
                @SerializedName("c-lunch")
                val cLunch: String?,
                @SerializedName("c-dinner")
                val cDinner: String?,
                @SerializedName("c-misc")
                val cMisc: String?,
                @SerializedName("c-fixcost")
                val cFixcost: String?,
                @SerializedName("ct-rev")
                val ctRev: String?,
                @SerializedName("res-recid")
                val resRecid: Int?,
                @SerializedName("sleeping")
                val sleeping: Boolean?,
                @SerializedName("row-disp")
                val rowDisp: Int?,
                @SerializedName("flag")
                val flag: String?,
                @SerializedName("zinr")
                val zinr: String?,
                @SerializedName("rstatus")
                val rstatus: Int?,
                @SerializedName("argt")
                val argt: String?,
                @SerializedName("currency")
                val currency: String?,
                @SerializedName("ratecode")
                val ratecode: String?,
                @SerializedName("pax")
                val pax: Int?,
                @SerializedName("com")
                val com: Int?,
                @SerializedName("ankunft")
                val ankunft: String?,
                @SerializedName("abreise")
                val abreise: String?,
                @SerializedName("rechnr")
                val rechnr: Int?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("ex-rate")
                val exRate: String?,
                @SerializedName("fix-rate")
                val fixRate: String?,
                @SerializedName("adult")
                val adult: Int?,
                @SerializedName("ch1")
                val ch1: Int?,
                @SerializedName("ch2")
                val ch2: Int?,
                @SerializedName("comch")
                val comch: Int?,
                @SerializedName("age1")
                val age1: Int?,
                @SerializedName("age2")
                val age2: String?
            )
        }

        data class CurrencyList(
            @SerializedName("currency-list")
            val currencyList: List<Any?>?
        )

        data class SumList(
            @SerializedName("sum-list")
            val sumList: List<Sum?>?
        ) {
            data class Sum(
                @SerializedName("bezeich")
                val bezeich: String?,
                @SerializedName("pax")
                val pax: Int?,
                @SerializedName("adult")
                val adult: Int?,
                @SerializedName("ch1")
                val ch1: Int?,
                @SerializedName("ch2")
                val ch2: Int?,
                @SerializedName("comch")
                val comch: Int?,
                @SerializedName("com")
                val com: Int?,
                @SerializedName("lodging")
                val lodging: Double?,
                @SerializedName("bfast")
                val bfast: Double?,
                @SerializedName("lunch")
                val lunch: Double?,
                @SerializedName("dinner")
                val dinner: Double?,
                @SerializedName("misc")
                val misc: Double?,
                @SerializedName("fixcost")
                val fixcost: Double?,
                @SerializedName("t-rev")
                val tRev: Double?
            )
        }

        data class SList(
            @SerializedName("s-list")
            val sList: List<Any?>?
        )
    }
}