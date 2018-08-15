package one.xcorp.feedster.domain

data class Feed(val imageUrl: String,
                val title: String,
                val description: String,
                val url: String,
                val users: Int)