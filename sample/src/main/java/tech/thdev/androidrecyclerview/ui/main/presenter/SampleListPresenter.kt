package tech.thdev.androidrecyclerview.ui.main.presenter

import android.content.Context
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.source.prefix.PrefixRepository
import tech.thdev.androidrecyclerview.ui.main.adapter.model.MainAdapterContract
import tech.thdev.base.presenter.CommonPresenter

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class SampleListPresenter(
    private val adapterContractView: MainAdapterContract.View,
    private val adapterContractModel: MainAdapterContract.Model,
    private val prefixRepository: PrefixRepository
) : CommonPresenter<SampleListContract.View>(),
    SampleListContract.Presenter {

    init {
        adapterContractView.setOnItemClickListener { _, position ->
            onListItemClick(position)
        }
    }

    /**
     * Adapter OnClick
     */
    private fun onListItemClick(position: Int) {
        adapterContractModel.getItem(position)?.intent?.let {
            view?.changeActivity(it)
        }
    }

    override fun getSampleList(prefix: String?, context: Context) {
        prefixRepository.getPrefixList(prefix, context)
            .subscribeOn(Schedulers.io())
            // list to item
            .flatMapIterable { it }
            .observeOn(AndroidSchedulers.mainThread())
            // add finish
            .doOnComplete {
                adapterContractView.notifyDataSetChanged()
            }
            .observeOn(Schedulers.io())
            // addItem...
            .subscribe {
                adapterContractModel.addItem(it)
            }
    }
}