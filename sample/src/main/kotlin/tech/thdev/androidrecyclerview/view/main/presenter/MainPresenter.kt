package tech.thdev.androidrecyclerview.view.main.presenter

import android.content.Context
import android.content.Intent
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.base.presenter.AbstractPresenter
import java.util.*


/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainPresenter : AbstractPresenter<MainContract.View>(), MainContract.Presenter {

    override var adapterContractView: MainAdapterContract.View? = null
    override var adapterContractModel: MainAdapterContract.Model? = null

    private val CATEGORY_NAME = "tech.thdev.androidrecyclerview.SAMPLE_CODE"

    override fun onListItemClick(position: Int) {
        val item = adapterContractModel?.getItem(position)
        view?.changeActivity(item?.intent)
    }

    override fun getSampleList(prefix: String?, context: Context) {
        // Rx 1.x
//        getMainList(prefix, context)
//                .subscribeOn(Schedulers.io())
//                .filter { it != null }
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnUnsubscribe {
//                    adapterContractView?.reload()
//                }
//                .subscribe {
//                    adapterContractModel?.addItem(it!!)
//                }
        // Rx 2.
        getMainList(prefix, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    adapterContractView?.reload()
                }
                .subscribe {
                    adapterContractModel?.addItems(it)
                }
    }

    private fun getMainList(prefix: String?, context: Context): Observable<List<MainItem>> {
        Log.d("TAG", "prefix : " + prefix)
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(CATEGORY_NAME)

        val pm = context.packageManager
        val list = pm.queryIntentActivities(mainIntent, 0)

        val prefixPath: List<String> = prefix?.let { it.split("/") } ?: ArrayList()
        val prefixWithSlash = prefix?.let { it + "/" } ?: ""

        list.forEach { Log.d("TAG", "it? ${it.activityInfo.name}") }

        // Rx 1.x
//        return Observable.from(list)
//                .map {
//                    val label = it.loadLabel(pm)?.toString() ?: it.activityInfo.name
//
//                    Log.e("TAG", "label $label prefixWithSlash $prefixWithSlash")
//
//                    if (prefixWithSlash.length == 0 || label.startsWith(prefixWithSlash)) {
//                        val labelPath = label.split("/")
//                        val nextLabel = if (prefixPath.size == 0) labelPath[0] else labelPath[prefixPath.size]
//
//                        Log.d("TAG", "labelPath $labelPath")
//                        Log.i("TAG", "nextLabel $nextLabel")
//
//                        if (prefixPath.size == labelPath.size - 1) {
//                            return@map MainItem(nextLabel, 0).setActivityIntent(it.activityInfo.applicationInfo.packageName, it.activityInfo.name)
//                        } else {
//                            return@map MainItem(nextLabel, 0).setBrowseIntent(context, prefix?.let { it + "/" + nextLabel } ?: nextLabel)
//                        }
//                    }
//                    null
//                }

        val itemList = ArrayList<MainItem>()

//        Subject.combineLatest()
//
//        // Rx 2.x
//        Observable.fromIterable(list)
//                .map {
//                    it.loadLabel(pm)?.toString() ?: it.activityInfo.name
//                }
//                .filter {
//                    prefixWithSlash.length == 0 || it.startsWith(prefixWithSlash)
//                }
//                .map {
//                    val labelPath = it.split("/")
//                    val nextLabel = if (prefixPath.size == 0) labelPath[0] else labelPath[prefixPath.size]
//
//                    Log.d("TAG", "labelPath $labelPath")
//                    Log.i("TAG", "nextLabel $nextLabel")
//
//                    if (prefixPath.size == labelPath.size - 1) {
//                        return@map MainItem(nextLabel, 0).setActivityIntent(it.activityInfo.applicationInfo.packageName, it.activityInfo.name)
//                    } else {
//                        return@map MainItem(nextLabel, 0).setBrowseIntent(context, prefix?.let { it + "/" + nextLabel } ?: nextLabel)
//                    }
//                }
//            .map {
//                val label = it.loadLabel(pm)?.toString() ?: it.activityInfo.name
//
//                Log.e("TAG", "label $label prefixWithSlash $prefixWithSlash")
//
//                if (prefixWithSlash.length == 0 || label.startsWith(prefixWithSlash)) {
//                    val labelPath = label.split("/")
//                    val nextLabel = if (prefixPath.size == 0) labelPath[0] else labelPath[prefixPath.size]
//
//                    Log.d("TAG", "labelPath $labelPath")
//                    Log.i("TAG", "nextLabel $nextLabel")
//
//                    if (prefixPath.size == labelPath.size - 1) {
//                        return@map MainItem(nextLabel, 0).setActivityIntent(it.activityInfo.applicationInfo.packageName, it.activityInfo.name)
//                    } else {
//                        return@map MainItem(nextLabel, 0).setBrowseIntent(context, prefix?.let { it + "/" + nextLabel } ?: nextLabel)
//                    }
//                }
//                null
//            }
//            .subscribe({
//                itemList.add(it!!)
//            }, {
//                Log.e("TAG", "Add error")
//            })


        return Observable.fromArray(itemList)
    }
}