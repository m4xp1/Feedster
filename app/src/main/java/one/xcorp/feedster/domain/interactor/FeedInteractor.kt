package one.xcorp.feedster.domain.interactor

import io.reactivex.Single
import one.xcorp.feedster.domain.Feed
import one.xcorp.feedster.domain.repository.FeedRepository
import javax.inject.Inject

class FeedInteractor @Inject constructor(private val feedRepository: FeedRepository) {

    fun getFeeds(): Single<List<Feed>> = feedRepository
            .getFeedsPage(1, ORDERING_BY_USERS)
            .map { it.feeds }

    companion object {
        const val ORDERING_BY_USERS = "users"
    }
}
