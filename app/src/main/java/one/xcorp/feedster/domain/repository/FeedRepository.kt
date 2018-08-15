package one.xcorp.feedster.domain.repository

import io.reactivex.Single
import one.xcorp.feedster.domain.Feed

interface FeedRepository {

    fun feeds(): Single<List<Feed>>
}
