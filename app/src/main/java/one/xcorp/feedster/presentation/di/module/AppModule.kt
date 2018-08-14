package one.xcorp.feedster.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import one.xcorp.feedster.presentation.Application
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideAppContext(): Context {
        return application
    }
}
