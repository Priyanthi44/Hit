package com.gymshark.hits.di

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import java.util.concurrent.TimeUnit

class AnnotationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        // Check if the request has the @Invocation annotation
        chain.request().tag(Invocation::class.java) ?: return chain.proceed(chain.request())
        //  add the Cache-Control
        val cacheControl = CacheControl.Builder()
            .maxAge(10, TimeUnit.DAYS)
            .build()
        return chain.proceed(request).newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .build()

    }


    private fun containedOnInvocation(invocation: Invocation): Set<Annotation> {
        return invocation.method().annotations.toSet()
    }
}
