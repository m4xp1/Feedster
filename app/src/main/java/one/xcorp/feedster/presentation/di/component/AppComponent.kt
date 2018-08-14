package one.xcorp.feedster.presentation.di.component

import dagger.Component
import one.xcorp.feedster.presentation.di.module.AppModule
import one.xcorp.feedster.presentation.view.activity.FeedActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: FeedActivity)
}
