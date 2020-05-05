package tech.thdev.androidrecyclerview.data.source.prefix

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.util.Log
import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.contract.CATEGORY_NAME
import tech.thdev.androidrecyclerview.data.PrefixItem

/**
 * Created by Tae-hwan on 14/11/2016.
 */
class PrefixAppDataSource : PrefixDataSource {

    override fun getPrefixList(prefix: String, context: Context): Flowable<List<PrefixItem>> {
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(CATEGORY_NAME)

        val packageManager = context.packageManager
        val intentList = packageManager.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES)

        val prefixPath: List<String> = prefix.split("/")
        val prefixWithSlash = prefix.plus("/")

        return Flowable.fromCallable {
            Flowable.fromIterable(intentList)
                .filter {
                    hashStartsWith(packageManager, prefixWithSlash, it)
                }
                .map { resolveInfo ->
                    val label = resolveInfo?.loadLabel(packageManager)?.toString()
                        ?: resolveInfo.activityInfo.name
                    val labelPath = label.split("/")
                    val nextLabel = if (prefixPath.isEmpty()) labelPath[0]
                    else labelPath[prefixPath.size]
                    Log.d("TAG", "nextLabel $nextLabel")

                    if (prefixPath.size == labelPath.size - 1) {
                        PrefixItem(
                            nextLabel,
                            0
                        ).setActivityIntent(
                            resolveInfo.activityInfo.applicationInfo.packageName,
                            resolveInfo.activityInfo.name
                        )

                    } else {
                        PrefixItem(nextLabel, 0).setBrowseIntent(
                            context,
                            prefix?.let { "$it/$nextLabel" } ?: nextLabel)
                    }
                }
                .distinct(PrefixItem::title)
                .toList()
                .blockingGet()
        }
    }

    private fun hashStartsWith(
        pm: PackageManager,
        prefixWithSlash: String,
        resolveInfo: ResolveInfo
    ): Boolean {
        val label = resolveInfo.loadLabel(pm)?.toString() ?: resolveInfo.activityInfo.name
        return prefixWithSlash.isEmpty() || label.startsWith(prefixWithSlash)
    }
}