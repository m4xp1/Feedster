package one.xcorp.feedster.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_feed.view.*
import one.xcorp.feedster.R
import one.xcorp.feedster.presentation.model.FeedModel

class FeedAdapter(private val list: List<FeedModel>) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(feed: FeedModel) {
            loadImage(feed.url)

            itemView.title.text = feed.title
            itemView.description.text = feed.description
            itemView.url.text = feed.url
            itemView.users.text = feed.users.toString()
        }

        private fun loadImage(url: String) {
            if (url.isEmpty()) {
                Glide.with(itemView.context).load(url).into(itemView.image)
            } else {
                Glide.with(itemView.context).clear(itemView.image)
                itemView.image.setImageDrawable(null)
            }
        }
    }
}