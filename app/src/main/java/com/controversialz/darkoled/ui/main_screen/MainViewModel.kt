package com.controversialz.darkoled.ui.main_screen

import android.app.Application
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val wallpaperManager = WallpaperManager.getInstance(getApplication())

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String>
        get() = _showMessage

    fun setWallpaper(bitmap: Bitmap) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
                }
                _showMessage.postValue("Wallpaper applied successfully")
            } catch (e: IOException) {
                Log.e("MainViewModel", "setWallpaper: ${e.message}")
                _showMessage.postValue("Wallpaper could not be applied")
            }
        }
    }
}