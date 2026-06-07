package com.utec.parcialfinal2929712023.data.api

import com.utec.parcialfinal2929712023.data.model.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ExchangeApi {

    @GET("v6/latest/USD")
    suspend fun getRates(): Response<ExchangeResponse>}