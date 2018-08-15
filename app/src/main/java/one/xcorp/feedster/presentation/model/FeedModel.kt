package one.xcorp.feedster.presentation.model

import android.support.v7.util.DiffUtil

data class FeedModel(val imageUrl: String,
                     val title: String,
                     val description: String,
                     val url: String,
                     val users: String) {

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FeedModel>() {
            override fun areItemsTheSame(oldItem: FeedModel, newItem: FeedModel): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: FeedModel, newItem: FeedModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}