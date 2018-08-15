package one.xcorp.feedster.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor.Level
import one.xcorp.feedster.R
import one.xcorp.feedster.data.service.FeedsterService
import one.xcorp.feedster.data.service.http.HttpClient

@Module
class NetworkModule {

    @Provides
    fun provideFeedsterService(context: Context, httpClient: OkHttpClient): FeedsterService {
        val url = context.getString(R.string.feedster_service_url)
        return FeedsterService.create(url, httpClient)
    }

    @Provides
    fun provideOkHttpClient(context: Context): OkHttpClient {
        // Пояснения по токену см. в HttpClient
        val token = context.getString(R.string.feedster_service_token)
        return HttpClient.create(token, Level.BODY)
    }
}
