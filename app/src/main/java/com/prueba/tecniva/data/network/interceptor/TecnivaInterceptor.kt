package com.prueba.tecniva.data.network.interceptor

import com.prueba.tecniva.util.constants.Constants.BEARER
import com.prueba.tecniva.util.constants.Constants.HEADER_AUTHORIZATION
import com.prueba.tecniva.util.constants.Constants.TOKEN
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TecnivaInterceptor @Inject constructor(): Interceptor {

    private var authToken = "$BEARER $TOKEN"

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().addHeader(
                HEADER_AUTHORIZATION, authToken
            ). build()
        )
    }

}