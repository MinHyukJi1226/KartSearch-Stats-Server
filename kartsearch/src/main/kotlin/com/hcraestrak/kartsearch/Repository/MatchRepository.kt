package com.hcraestrak.kartsearch.Repository

import com.hcraestrak.kartsearch.retrofit.client.RetrofitClientInstance
import com.hcraestrak.kartsearch.retrofit.response.AllMatch
import com.hcraestrak.kartsearch.retrofit.response.MatchDetailSingle
import com.hcraestrak.kartsearch.retrofit.response.MatchDetailTeam
import com.hcraestrak.kartsearch.retrofit.service.MatchService
import org.springframework.stereotype.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Repository
class MatchRepository {
    private val service: MatchService by lazy { RetrofitClientInstance.matchService }
    
    fun getAllMatch(matchType: String): AllMatch? {
        var allMatchData: AllMatch? = null
        service.allMatch(limit = 100, match_types = matchType).enqueue(object: Callback<AllMatch> {
            override fun onResponse(call: Call<AllMatch>, response: Response<AllMatch>) {
                allMatchData = if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }
            override fun onFailure(call: Call<AllMatch>, t: Throwable) {
                allMatchData = null
            }
        })
        return allMatchData
    }

    fun singleMatchDetail(matchId: String): MatchDetailSingle? {
        var singleData: MatchDetailSingle? = null
        service.specificMatchInquiry(matchId).enqueue(object: Callback<MatchDetailSingle> {
            override fun onResponse(call: Call<MatchDetailSingle>, response: Response<MatchDetailSingle>) {
                singleData = if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }

            override fun onFailure(call: Call<MatchDetailSingle>, t: Throwable) {
                singleData = null
            }
        })
        return singleData
    }

    fun teamMatchDetail(matchId: String): MatchDetailTeam? {
        var teamData: MatchDetailTeam? = null
        service.specificTeamMatchInquiry(matchId).enqueue(object: Callback<MatchDetailTeam> {
            override fun onResponse(call: Call<MatchDetailTeam>, response: Response<MatchDetailTeam>) {
                teamData = if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }

            override fun onFailure(call: Call<MatchDetailTeam>, t: Throwable) {
                teamData = null
            }
        })
        return teamData
    }
}