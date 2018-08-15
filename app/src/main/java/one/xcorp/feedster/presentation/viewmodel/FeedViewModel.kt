package one.xcorp.feedster.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import one.xcorp.feedster.presentation.model.FeedModel
import one.xcorp.feedster.presentation.model.StatusModel
import javax.inject.Inject

class FeedViewModel @Inject constructor() : ViewModel() {

    private val _feeds = MutableLiveData<StatusModel<List<FeedModel>>>()

    val feeds: LiveData<StatusModel<List<FeedModel>>>
        get() = _feeds

    fun load() {

    }

    fun retry() {

    }
}
