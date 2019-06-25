package com.khairilushan.mpp.movie.libs.utils

import io.ktor.client.engine.HttpClientEngine

expect object PlatformServiceLocator {
    val httpClientEngine: HttpClientEngine
}
