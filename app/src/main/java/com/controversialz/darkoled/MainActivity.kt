package com.controversialz.darkoled

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorInt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.system.exitProcess


class MainActivity : ComponentActivity() {
    private val bitmap by lazy { getBitmapFromResource(R.drawable.black) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor()

        setContent {
            MainScreen() {
                setWallpapers(bitmap, applicationContext)
            }
        }
    }

    private fun setStatusBarColor() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = resources.getColor(R.color.black)
    }

    private fun getBitmapFromResource(resourceId: Int): Bitmap {
        return BitmapFactory.decodeResource(resources, resourceId)
    }

    private fun setWallpapers(bitmap: Bitmap, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val wallpaperManager = WallpaperManager.getInstance(applicationContext)
            try {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Wait around 15 seconds.", Toast.LENGTH_SHORT).show()
                }
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Wallpaper applied successfully", Toast.LENGTH_SHORT)
                        .show()
                }
            } catch (e: IOException) {
                Log.e("Debug", "setWallpapers: ${e.message}")
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Wallpaper could not be applied", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

@Composable
fun MainScreen(onApplyClicked: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(top = 20.dp, start = 6.dp, end = 6.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(28.dp, 28.dp),
                    tint = Color.Black
                )
            }
            Text(
                text = "DarkOLED",
                color = Color.White,
                fontSize = 24.sp
            )
            Button(
                onClick = { android.os.Process.killProcess(android.os.Process.myPid()) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Menu",
                    modifier = Modifier.size(28.dp, 28.dp),
                    tint = Color.Black
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(400.dp, 400.dp)
                    .align(Alignment.CenterHorizontally),
                tint = Color.Yellow
            )
            Button(
                onClick = {
                    coroutineScope.launch {
                        onApplyClicked()
                    }
                },
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(28.dp, 28.dp)
                        .align(CenterVertically),
                    tint = Color.Black
                )
                Text(
                    text = "Apply",
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Menu",
            modifier = Modifier
                .size(28.dp, 28.dp)
                .align(Alignment.CenterHorizontally),
            tint = Color.Yellow
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

}

