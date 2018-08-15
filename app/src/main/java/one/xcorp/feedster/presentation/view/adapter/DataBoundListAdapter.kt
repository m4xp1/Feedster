package one.xcorp.feedster.presentation.view.adapter

import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.AsyncDifferConfig
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil.ItemCallback
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import one.xcorp.feedster.presentation.view.adapter.DataBoundListAdapter.ViewHolder

abstract class DataBoundListAdapter<T, V : ViewDataBinding>(diffCallback: ItemCallback<T>) :
        ListAdapter<T, ViewHolder<V>>(AsyncDifferConfig.Builder<T>(diffCallback).build()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        val binding = createBinding(parent, viewType)
        return ViewHolder(binding)
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): V

    override fun onBindViewHolder(holder: ViewHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: V, item: T)

    class ViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
}
