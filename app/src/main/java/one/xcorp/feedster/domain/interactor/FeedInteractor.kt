package one.xcorp.feedster.domain.interactor

import io.reactivex.Single
import one.xcorp.feedster.data.exception.NetworkConnectionException
import one.xcorp.feedster.domain.Feed
import javax.inject.Inject

class FeedInteractor @Inject constructor() {

    fun getListFeeds(): Single<List<Feed>> {
        // TODO maXp: add implementation.
        return Single.error(NetworkConnectionException())
    }
}
