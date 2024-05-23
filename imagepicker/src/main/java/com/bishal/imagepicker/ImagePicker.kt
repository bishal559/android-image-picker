package com.bishal.imagepicker

import android.app.Activity
import android.content.Intent
import com.bishal.imagepicker.classes.Const
import com.bishal.imagepicker.gallery.SelectActivity
import kotlin.math.abs


class ImagePicker (private val activity: Activity, private val isMultipleSelection:Boolean,
                   private val isTakePicture:Boolean, private val title:String) {


    constructor(activity: Activity,title:String):this(activity,false,false,title)

    constructor(activity: Activity, isMultipleSelection:Boolean,title:String):this(activity,isMultipleSelection,false,title)





//        private final BroadcastReceiver br = new BroadcastReceiver()
//        {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                if (multiSelect)
//                    mListener.selectedPics(addresses);
//                else
//                    sListener.selectedPic(addresses.get(0));
//                activity.unregisterReceiver(br);
//            }
//        };

    fun show(

        cropXRatio: Int,
        cropYRatio: Int,
        numberOfPictures: Int = 1,
        selectedImages:(List<String>)->Unit
    ) {
        val count = when {
            numberOfPictures <= 0 -> 1
            numberOfPictures > 100 -> 100
            else -> numberOfPictures
        }
        Const.addresses= mutableListOf()
        Const.cropXRatio = abs(cropXRatio).toFloat()
        Const.cropYRatio = abs(cropYRatio).toFloat()

        Const.numberOfPictures = count

        activity.startActivity(Intent(activity, SelectActivity::class.java).apply {
            putExtra("isMultipleSelection",isMultipleSelection)
            putExtra("isTakePicture",isTakePicture)
            putExtra("title",title)
        })


    }
}
