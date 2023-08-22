package `in`.mrkaydev.portfolio.networking

import `in`.mrkaydev.portfolio.data.*
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

val httpClient = HttpClient {
    expectSuccess = true
    install(HttpTimeout) {
        val timeout = 5000L
        connectTimeoutMillis = timeout
        requestTimeoutMillis = timeout
        socketTimeoutMillis = timeout
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.HEADERS
    }
    install(ContentNegotiation) {
        json(Json {
            serializersModule = SerializersModule {
                polymorphic(WidgetConfig::class) {
                    subclass(BasicTextWidgetConfig::class)
                    subclass(BulletinTextWidgetConfig::class)
                    subclass(DividerWidgetConfig::class)
                    subclass(MiddleBulletinRowTextWidgetConfig::class)
                    subclass(RowTextWidgetConfig::class)
                    subclass(SpacerWidgetConfig::class)
                    subclass(SpannedTextWidgetConfig::class)
                }
            }
        })
    }
}