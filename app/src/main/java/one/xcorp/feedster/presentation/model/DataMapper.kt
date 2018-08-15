package one.xcorp.feedster.presentation.model

import one.xcorp.feedster.domain.Feed

fun Feed.toModel() = FeedModel(this.imageUrl, this.title,
        this.description, this.url, this.users.toString())

fun Iterable<Feed>.toModel() = map { i -> i.toModel() }