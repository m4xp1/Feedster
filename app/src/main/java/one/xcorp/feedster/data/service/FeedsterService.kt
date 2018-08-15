package one.xcorp.feedster.data.service

import io.reactivex.Single
import okhttp3.OkHttpClient
import one.xcorp.feedster.data.entity.FeedsPageEntity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedsterService {

    @GET("v1/feeds")
    fun getFeedsPage(@Query("page") page: Int,
                     @Query("ordering") ordering: String? = null): Single<FeedsPageEntity>

    companion object Factory {
        fun create(baseUrl: String, httpClient: OkHttpClient): FeedsterService {
            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
                    .create(FeedsterService::class.java)
        }
    }
}