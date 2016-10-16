package tech.thdev.androidrecyclerview.view.main.presenter

import android.content.Context
import android.content.Intent
import android.util.Log
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import tech.thdev.androidrecyclerview.adapter.model.MainListContract
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.base.presenter.AbstractPresenter
import java.util.*


/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainPresenter : AbstractPresenter<MainContract.View>(), MainContract.Presenter {

    override var listContractView: MainListContract.View? = null
    override var listContractModel: MainListContract.Model? = null

    private val CATEGORY_NAME = "tech.thdev.androidrecyclerview.SAMPLE_CODE"

    override fun onListItemClick(position: Int) {
        val item = listContractModel?.getItem(position)
        view?.changeActivity(item?.intent)
    }

    override fun getSampleList(prefix: String?, context: Context) {
        getMainList(prefix, context)
                .subscribeOn(Schedulers.io())
                .filter { it != null }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnUnsubscribe {
                    listContractView?.reload()
                }
                .subscribe {
                    listContractModel?.addItem(it!!)
                }
    }

    private fun getMainList(prefix: String?, context: Context): Observable<MainItem?> {
        Log.d("TAG", "prefix : " + prefix)
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(CATEGORY_NAME)

        val pm = context.packageManager
        val list = pm.queryIntentActivities(mainIntent, 0)

        val prefixPath: List<String> = prefix?.let { it.split("/") } ?: ArrayList()
        val prefixWithSlash = prefix?.let { it + "/" } ?: ""

        list.forEach { Log.d("TAG", "it? ${it.activityInfo.name}") }

        return Observable.from(list)
                .map {
                    val label = it.loadLabel(pm)?.toString() ?: it.activityInfo.name

                    Log.e("TAG", "label $label prefixWithSlash $prefixWithSlash")

                    if (prefixWithSlash.length == 0 || label.startsWith(prefixWithSlash)) {
                        val labelPath = label.split("/")
                        val nextLabel = if (prefixPath.size == 0) labelPath[0] else labelPath[prefixPath.size]

                        Log.d("TAG", "labelPath $labelPath")
                        Log.i("TAG", "nextLabel $nextLabel")

                        if (prefixPath.size == labelPath.size - 1) {
                            return@map MainItem(nextLabel, 0).setActivityIntent(it.activityInfo.applicationInfo.packageName, it.activityInfo.name)
                        } else {
                            return@map MainItem(nextLabel, 0).setBrowseIntent(context, prefix?.let { it + "/" + nextLabel } ?: nextLabel)
                        }
                    }
                    null
                }
    }
}