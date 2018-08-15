package one.xcorp.feedster.data.entity

import one.xcorp.feedster.domain.Feed

fun FeedEntity.toFeed() = Feed(this.imageUrl, this.title,
        this.description, this.url, this.users)

fun Iterable<FeedEntity>.toFeed() = map { i -> i.toFeed() }