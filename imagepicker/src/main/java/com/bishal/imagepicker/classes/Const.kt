package com.bishal.imagepicker.classes

import java.text.SimpleDateFormat
import java.util.*

object Const {

    var cropXRatio:Float=0f
    var cropYRatio:Float=0f
    var numberOfPictures=1
    var multiSelect=false
    lateinit var addresses :MutableList<String>
    const val INTENT_FILTER_ACTION_NAME = "instagrampicker_refresh"
    fun getCurrentDate(): String =SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US).format(Date())

}