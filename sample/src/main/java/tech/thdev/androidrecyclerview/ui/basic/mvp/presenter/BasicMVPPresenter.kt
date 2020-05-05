package tech.thdev.androidrecyclerview.ui.basic.mvp.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.base.presenter.CommonPresenter
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.model.BaseRecyclerView

/**
 * Created by Tae-hwan on 11/10/2016.
 */
class BasicMVPPresenter(
    private val adapterView: BaseRecyclerView,
    private val adapterModel: BaseRecyclerModel<String>
) : CommonPresenter<BasicMVPContract.View>(),
    BasicMVPContract.Presenter {

    init {
        adapterView.setOnItemClickListener { _, position ->
            adapterModel.getItem(position)?.let {
                view?.showToast(it)
            }
        }
    }

    override fun loadList(count: Int) {
        Flowable.range(1, count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                adapterView.notifyDataSetChanged()
            }
            .subscribe({ // onNext
                adapterModel.addItem("Item : $it")
            }, { // onError

            })
    }
}