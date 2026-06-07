# 💱 Conversor de Monedas - Android Kotlin

Aplicación móvil desarrollada en **Kotlin** utilizando **Jetpack Compose** que permite convertir una cantidad en dólares estadounidenses (USD) a diferentes monedas de Centroamérica y México, obteniendo los tipos de cambio actualizados desde una API en tiempo real.

## 📱 Funcionalidades

* Ingreso de cantidad en dólares estadounidenses (USD).
* Conversión a:

  * Quetzales Guatemaltecos (GTQ)
  * Lempiras Hondureños (HNL)
  * Córdobas Nicaragüenses (NIO)
  * Pesos Mexicanos (MXN)
* Consulta de tipos de cambio actualizados mediante API.
* Validación de entrada de datos.
* Manejo de errores de conexión y respuestas de la API.
* Interfaz moderna desarrollada con Jetpack Compose.

## 🛠️ Tecnologías utilizadas

* Kotlin
* Jetpack Compose
* Material 3
* Retrofit
* Coroutines
* ViewModel (MVVM)

## 🏗️ Arquitectura

El proyecto utiliza el patrón de arquitectura **MVVM (Model-View-ViewModel)** para separar responsabilidades y facilitar el mantenimiento y las pruebas.

```text
UI (Compose)
     │
     ▼
ViewModel
     │
     ▼
Repository
     │
     ▼
Retrofit API
```

## 📂 Estructura del proyecto

```text
app
├── data
│   ├── api
│   └── model
├── repository
├── ui
├── viewmodel
└── MainActivity.kt
```

## 🌐 API utilizada

Exchange Rate API

Endpoint:

https://open.er-api.com/v6/latest/USD

Ejemplo de respuesta:

```json
{
  "rates": {
    "GTQ": 7.67,
    "HNL": 25.50,
    "NIO": 36.70,
    "MXN": 19.20
  }
}
```

## 🚀 Instalación y ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/93Cast/ConversorDeMonedas.git
```

2. Abrir el proyecto en Android Studio.

3. Sincronizar dependencias Gradle.

4. Ejecutar la aplicación en un emulador o dispositivo físico.



## ✅ Validaciones implementadas

* Campo de monto obligatorio.
* Verificación de formato numérico válido.
* Manejo de errores de conexión.
* Manejo de errores de respuesta de la API.
* Validación de moneda seleccionada.

## 📚 Aprendizajes del proyecto

* Consumo de APIs REST con Retrofit.
* Manejo de estados en Jetpack Compose.
* Uso de Coroutines para tareas asíncronas.
* Implementación de arquitectura MVVM.
* Diseño de interfaces modernas con Material 3.

## 👨‍💻 Autor

Daniel Sosa

