package one.xcorp.feedster.data.service.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import one.xcorp.feedster.BuildConfig

interface HttpClient {

    companion object Factory {

        // По хорошему так делать нельзя. Токен может протухать, а потому стоит пилить
        // отдельный механизм аутентификации, с правильными интерсепторами,
        // но мы договаривались на хардкор и потому так =)
        fun create(token: String, logLevel: Level): OkHttpClient {
            val builder = OkHttpClient().newBuilder()

            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = logLevel
                builder.addInterceptor(interceptor)
            }

            builder.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Token $token").build()
                return@addInterceptor chain.proceed(request)
            }

            return builder.build()
        }
    }
}