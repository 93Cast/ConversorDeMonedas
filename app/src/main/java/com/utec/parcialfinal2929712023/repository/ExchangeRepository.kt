package com.utec.parcialfinal2929712023.repository
import com.utec.parcialfinal2929712023.data.api.RetrofitClient
class ExchangeRepository {

    suspend fun getRates() =
        RetrofitClient.api.getRates()
}