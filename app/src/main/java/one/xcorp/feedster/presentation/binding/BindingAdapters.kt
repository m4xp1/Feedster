package one.xcorp.feedster.presentation.binding

import android.databinding.BindingAdapter
import android.view.View
import android.view.View.*
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url?.isEmpty() == false) {
        Glide.with(context).load(url).into(this)
    } else {
        Glide.with(context).clear(this)
        setImageDrawable(null)
    }
}

@set:BindingAdapter("gone")
var View.gone
    get() = visibility == GONE
    set(gone) {
        visibility = if (gone) GONE else VISIBLE
    }

@set:BindingAdapter("visible")
var View.visible
    get() = visibility == VISIBLE
    set(visible) {
        visibility = if (visible) VISIBLE else INVISIBLE
    }