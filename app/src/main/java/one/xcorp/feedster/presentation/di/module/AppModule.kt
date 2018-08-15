package one.xcorp.feedster.presentation.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import one.xcorp.feedster.data.repository.FeedDataRepository
import one.xcorp.feedster.domain.repository.FeedRepository
import one.xcorp.feedster.presentation.Application
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindApplicationContext(application: Application): Context

    @Binds
    abstract fun bindFeedRepository(repository: FeedDataRepository): FeedRepository
}
