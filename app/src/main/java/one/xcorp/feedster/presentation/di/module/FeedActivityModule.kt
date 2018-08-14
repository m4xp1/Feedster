package one.xcorp.feedster.presentation.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import one.xcorp.feedster.presentation.view.activity.FeedActivity

@Module
abstract class FeedActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedActivity(): FeedActivity
}
