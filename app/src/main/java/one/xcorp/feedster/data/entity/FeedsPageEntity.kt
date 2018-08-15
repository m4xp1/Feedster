package one.xcorp.feedster.data.entity

import com.google.gson.annotations.SerializedName

data class FeedsPageEntity(
        @SerializedName("results")
        val feeds: List<FeedEntity> = emptyList()
)