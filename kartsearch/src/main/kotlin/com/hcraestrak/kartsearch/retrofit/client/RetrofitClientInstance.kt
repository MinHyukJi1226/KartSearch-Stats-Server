package com.hcraestrak.kartsearch.retrofit.client

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match
import com.google.gson.Gson
import com.hcraestrak.kartsearch.retrofit.service.MatchService
import com.hcraestrak.kartsearch.retrofit.util.TokenInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClientInstance {
    private const val URL = "https://api.nexon.co.kr/"
    private val gson = Gson().newBuilder().setLenient().create()

    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(TokenInterceptor()).build()

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
    }

    val matchService: MatchService = retrofit.create(MatchService::class.java)

}