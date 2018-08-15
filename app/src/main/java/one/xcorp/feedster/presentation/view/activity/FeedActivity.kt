package one.xcorp.feedster.presentation.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import one.xcorp.feedster.R
import one.xcorp.feedster.databinding.ActivityFeedBinding
import one.xcorp.feedster.presentation.di.Injectable
import one.xcorp.feedster.presentation.view.adapter.FeedAdapter
import one.xcorp.feedster.presentation.viewmodel.FeedViewModel
import javax.inject.Inject

class FeedActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityFeedBinding
    private lateinit var feedViewModel: FeedViewModel

    private lateinit var adapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_feed)
        feedViewModel = ViewModelProviders
                .of(this, viewModelFactory).get(FeedViewModel::class.java)

        binding.viewModel = feedViewModel

        binding.refresh.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.purple))

        adapter = FeedAdapter()
        binding.recycler.adapter = adapter
        initFeedList(feedViewModel)

        feedViewModel.loadFeeds()
    }

    private fun initFeedList(viewModel: FeedViewModel) {
        viewModel.feeds.observe(this, Observer { status ->
            if (status?.data != null) {
                adapter.submitList(status.data)
            } else {
                adapter.submitList(emptyList())
            }
            binding.status = status
        })
    }
}
