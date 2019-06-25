package com.khairilushan.mpp.movie.libs.utils

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

actual object PlatformServiceLocator {
    actual val httpClientEngine: HttpClientEngine by lazy {
        Ios.create()
    }
}
