package one.xcorp.feedster.data.entity

import com.google.gson.annotations.SerializedName

data class FeedEntity(
        @SerializedName("imageUrl")
        val imageUrl: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("users")
        val users: Int
)