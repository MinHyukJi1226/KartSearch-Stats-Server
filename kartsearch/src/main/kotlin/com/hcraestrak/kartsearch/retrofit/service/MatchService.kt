package com.hcraestrak.kartsearch.retrofit.service

import com.hcraestrak.kartsearch.retrofit.response.AllMatch
import com.hcraestrak.kartsearch.retrofit.response.MatchDetailSingle
import com.hcraestrak.kartsearch.retrofit.response.MatchDetailTeam
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MatchService {

    @GET("/kart/v1.0/matches/{match_id}")
    fun specificMatchInquiry(@Path("match_id") match_id: String): Call<MatchDetailSingle>

    @GET("/kart/v1.0/matches/{match_id}")
    fun specificTeamMatchInquiry(@Path("match_id") match_id: String): Call<MatchDetailTeam>

    @GET("/kart/v1.0/matches/all")
    fun allMatch(
            @Query("start_date") start_date: String? = null,
            @Query("end_date") end_date: String? = null,
            @Query("offset") offset: Int = 0,
            @Query("limit") limit: Int = 10,
            @Query("match_types") match_types: String
    ): Call<AllMatch>

}