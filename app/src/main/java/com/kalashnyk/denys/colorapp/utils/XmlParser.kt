package com.kalashnyk.denys.colorapp.utils

import android.content.Context
import com.kalashnyk.denys.colorapp.R
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.xmlpull.v1.XmlPullParser

class XmlParser {

    companion object {

        fun parseColors(context: Context): Single<List<ColorEntity>>? {
            var list: ArrayList<ColorEntity> = ArrayList()
            var parser: XmlPullParser = context.resources.getXml(R.xml.col)

            while (parser.eventType != XmlPullParser.END_DOCUMENT) {
                if (parser.eventType == XmlPullParser.START_TAG
                    && parser.name == "color"
                ) {
                    list.add(ColorEntity(parser.getAttributeValue(0), parser.getAttributeValue(1)))
                }
                parser.next()

            }
            var tmp = list.toList()
            return Single.just(tmp).compose(singleTransformer())
        }

        private fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

}