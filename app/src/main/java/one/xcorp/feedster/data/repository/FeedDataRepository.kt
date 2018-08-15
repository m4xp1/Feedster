package one.xcorp.feedster.data.repository

import io.reactivex.Single
import one.xcorp.feedster.data.entity.toFeedsPage
import one.xcorp.feedster.data.service.FeedsterService
import one.xcorp.feedster.domain.FeedsPage
import one.xcorp.feedster.domain.repository.FeedRepository
import javax.inject.Inject

class FeedDataRepository @Inject constructor(
        private val feedsterService: FeedsterService) : FeedRepository {

    override fun getFeedsPage(page: Int, ordering: String?): Single<FeedsPage> {
        return feedsterService
                .getFeedsPage(page, ordering)
                .map { it.toFeedsPage() }
    }
}
