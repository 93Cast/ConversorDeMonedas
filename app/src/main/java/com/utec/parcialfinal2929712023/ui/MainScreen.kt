package com.utec.parcialfinal2929712023.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.utec.parcialfinal2929712023.viewmodel.CurrencyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val vm: CurrencyViewModel =
        viewModel()

    var amount by remember {
        mutableStateOf("")
    }

    val currencies = listOf(
        "GTQ",
        "HNL",
        "NIO",
        "MXN"
    )

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedCurrency by remember {
        mutableStateOf("GTQ")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            "Conversor USD",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = {
                Text("Cantidad USD")
            }
        )

        Spacer(
            Modifier.height(10.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {

            OutlinedTextField(
                value = selectedCurrency,
                onValueChange = {},
                readOnly = true,
                label = {
                    Text("Moneda")
                }
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {

                currencies.forEach {

                    DropdownMenuItem(
                        text = {
                            Text(it)
                        },
                        onClick = {

                            selectedCurrency = it
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(
            Modifier.height(20.dp)
        )

        Button(
            onClick = {

                val value =
                    amount.toDoubleOrNull()

                if(value == null){

                    vm.error =
                        "Ingrese un número válido"

                } else {

                    vm.convert(
                        value,
                        selectedCurrency
                    )
                }
            }
        ) {

            Text("Convertir")
        }

        Spacer(
            Modifier.height(20.dp)
        )

        if(vm.result.isNotEmpty()){

            Text(
                "Resultado: ${vm.result}"
            )
        }

        if(vm.error.isNotEmpty()){

            Text(
                vm.error,
                color =
                    MaterialTheme.colorScheme.error
            )
        }
    }
}