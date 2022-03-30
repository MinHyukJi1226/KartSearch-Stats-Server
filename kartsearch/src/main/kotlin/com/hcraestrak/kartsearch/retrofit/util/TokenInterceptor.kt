package com.hcraestrak.kartsearch.retrofit.util

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor: Interceptor {
    private val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTQwOTgzMTY5NiIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTM5MyIsIlgtQXBwLVJhdGUtTGltaXQiOiI1MDA6MTAiLCJuYmYiOjE2Mzg2ODI2NDMsImV4cCI6MTY1NDIzNDY0MywiaWF0IjoxNjM4NjgyNjQzfQ.3TemvuJHLKX-VnhIJSQ9DuD8zkmRpsYqa-FXyRTMmTQ"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("Authorization", ACCESS_TOKEN).build()
        return chain.proceed(request)
    }
}