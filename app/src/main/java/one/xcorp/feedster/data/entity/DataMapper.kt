package one.xcorp.feedster.data.entity

import one.xcorp.feedster.domain.Feed
import one.xcorp.feedster.domain.FeedsPage

fun FeedsPageEntity.toFeedsPage() = FeedsPage(this.feeds.toFeed())

fun FeedEntity.toFeed() = Feed(this.imageUrl, this.title,
        this.description, this.url, this.users)

fun Iterable<FeedEntity>.toFeed() = map { i -> i.toFeed() }