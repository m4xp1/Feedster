package one.xcorp.feedster.presentation

import one.xcorp.feedster.presentation.di.component.AppComponent
import one.xcorp.feedster.presentation.di.component.DaggerAppComponent
import one.xcorp.feedster.presentation.di.module.AppModule

class Application : android.app.Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initializeInjector();
    }

    private fun initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build();
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}
