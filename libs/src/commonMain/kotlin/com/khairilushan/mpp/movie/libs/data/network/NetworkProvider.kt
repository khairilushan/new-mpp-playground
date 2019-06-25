package com.khairilushan.mpp.movie.libs.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.request
import io.ktor.http.URLProtocol
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

@UnstableDefault
internal class NetworkProvider<T : Endpoint>(clientEngine: HttpClientEngine) {

    private val client = HttpClient(clientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    internal suspend fun <R> request(endpoint: T, strategy: DeserializationStrategy<R>): R {
        val response: String = client.request {
            method = endpoint.method
            url.apply {
                protocol = URLProtocol.HTTPS
                host = endpoint.baseUrl

                val query = endpoint.parameters.map { "${it.key}=${it.value}" }.joinToString("&")
                encodedPath = if (query.isNotEmpty()) {
                    "${endpoint.path}?$query"
                } else {
                    endpoint.path
                }
            }
        }

        return Json.parse(strategy, response)
    }

}
