package one.xcorp.feedster.presentation

import android.app.Activity
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import one.xcorp.feedster.presentation.di.component.DaggerAppComponent
import javax.inject.Inject

class Application : android.app.Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this).build()
                .inject(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}
