package tech.thdev.androidrecyclerview.view.main.presenter

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.source.prefix.PrefixRepository
import tech.thdev.base.presenter.AbstractPresenter


/**
 * Created by Tae-hwan on 11/10/2016.
 */

class SampleListPresenter : AbstractPresenter<SampleListContract.View>(), SampleListContract.Presenter {

    override var prefixRepository: PrefixRepository? = null

    override var adapterContractModel: MainAdapterContract.Model? = null
    override var adapterContractView: MainAdapterContract.View? = null
        set(value) {
            field = value
            adapterContractView?.setOnItemClickListener { adapter, i -> onListItemClick(i) }
        }

    /**
     * Adapter OnClick
     */
    private fun onListItemClick(position: Int) {
        adapterContractModel?.getItem(position)?.intent?.let {
            view?.changeActivity(it)
        }
    }

    override fun getSampleList(prefix: String?, context: Context) {
        prefixRepository?.getPrefixList(prefix, context)
                ?.subscribeOn(Schedulers.io())
                // list to item
                ?.flatMapIterable { it }
                ?.observeOn(AndroidSchedulers.mainThread())
                // add finish
                ?.doOnComplete {
                    adapterContractView?.notifyDataSetChanged()
                }
                ?.observeOn(Schedulers.io())
                // addItem...
                ?.subscribe {
                    adapterContractModel?.addItem(it)
                }
    }
}