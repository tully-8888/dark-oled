package com.controversialz.darkoled.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

 fun getBitmapFromResource(resourceId: Int,resources:Resources): Bitmap {
    return BitmapFactory.decodeResource(resources, resourceId)
}