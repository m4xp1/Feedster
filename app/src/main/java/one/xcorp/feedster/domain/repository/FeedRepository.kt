package one.xcorp.feedster.domain.repository

import io.reactivex.Single
import one.xcorp.feedster.domain.FeedsPage

interface FeedRepository {

    fun getFeedsPage(page: Int, ordering: String? = null): Single<FeedsPage>
}
