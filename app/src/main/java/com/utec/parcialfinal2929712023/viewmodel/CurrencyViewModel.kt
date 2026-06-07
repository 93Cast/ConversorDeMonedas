package com.utec.parcialfinal2929712023.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utec.parcialfinal2929712023.repository.ExchangeRepository
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {

    private val repository = ExchangeRepository()

    var result by mutableStateOf("")
    var error by mutableStateOf("")

    fun convert(
        amount: Double,
        currency: String
    ) {

        viewModelScope.launch {

            try {

                val response =
                    repository.getRates()

                if(response.isSuccessful){

                    val rate =
                        response.body()
                            ?.rates
                            ?.get(currency)

                    if(rate != null){

                        val conversion =
                            amount * rate

                        result =
                            "%.2f $currency"
                                .format(conversion)

                        error = ""

                    } else {

                        error =
                            "Moneda no encontrada"
                    }

                } else {

                    error =
                        "Error de API"
                }

            } catch (e: Exception){

                error =
                    "Sin conexión o error de red"

            }
        }
    }
}