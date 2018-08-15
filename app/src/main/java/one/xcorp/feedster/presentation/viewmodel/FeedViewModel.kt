package one.xcorp.feedster.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import one.xcorp.feedster.domain.interactor.FeedInteractor
import one.xcorp.feedster.presentation.exception.MessageFactory
import one.xcorp.feedster.presentation.model.FeedModel
import one.xcorp.feedster.presentation.model.StatusModel
import one.xcorp.feedster.presentation.model.StatusModel.Companion.error
import one.xcorp.feedster.presentation.model.StatusModel.Companion.loading
import one.xcorp.feedster.presentation.model.StatusModel.Companion.success
import one.xcorp.feedster.presentation.model.toModel
import javax.inject.Inject

class FeedViewModel @Inject constructor(
        private val messageFactory: MessageFactory,
        private val feedInteractor: FeedInteractor) : ViewModel() {

    private val _feeds = MutableLiveData<StatusModel<List<FeedModel>>>()
    val feeds: LiveData<StatusModel<List<FeedModel>>>
        get() = _feeds

    private val disposables = CompositeDisposable()

    fun loadFeeds() {
        if (_feeds.value == null) {
            executeLoadingFeeds()
        }
    }

    fun reloadFeeds() {
        executeLoadingFeeds()
    }

    private fun executeLoadingFeeds() {
        disposables.clear()
        disposables.add(feedInteractor.getFeeds()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { _feeds.value = loading(_feeds.value?.data) }
                .map { success(it.toModel()) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ _feeds.value = it }, { _feeds.value = getError(it) }))
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    private fun getError(error: Throwable) = error(messageFactory.createMessage(error), null)
}