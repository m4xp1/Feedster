package one.xcorp.feedster.presentation.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import one.xcorp.feedster.presentation.Application

@Module(includes = [ViewModelModule::class])
abstract class AppModule {

    @Binds
    abstract fun bindApplicationContext(application: Application): Context
}
