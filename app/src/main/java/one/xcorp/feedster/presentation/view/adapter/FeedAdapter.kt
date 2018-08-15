package one.xcorp.feedster.presentation.view.adapter

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import one.xcorp.feedster.R
import one.xcorp.feedster.databinding.ItemFeedBinding
import one.xcorp.feedster.presentation.model.FeedModel

class FeedAdapter : DataBoundListAdapter<FeedModel, ItemFeedBinding>(FeedModel.DIFF_CALLBACK) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemFeedBinding {
        return DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_feed, parent, false)
    }

    override fun bind(binding: ItemFeedBinding, item: FeedModel) {
        binding.feed = item
    }
}