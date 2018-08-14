package one.xcorp.feedster.presentation.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import one.xcorp.feedster.presentation.Application
import one.xcorp.feedster.presentation.di.module.AppModule
import one.xcorp.feedster.presentation.di.module.FeedActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, FeedActivityModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: Application)
}