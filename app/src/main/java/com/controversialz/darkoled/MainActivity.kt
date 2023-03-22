package com.controversialz.darkoled

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.controversialz.darkoled.ui.main_screen.MainScreen
import com.controversialz.darkoled.ui.main_screen.MainViewModel
import com.controversialz.darkoled.utils.getBitmapFromResource


class MainActivity : ComponentActivity() {
  private val bitmap by lazy { getBitmapFromResource(R.drawable.black,resources) }
 private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            MainScreen(
                onApplyClicked = {
                    viewModel.setWallpaper(bitmap)
                },
                showMessage = viewModel.showMessage
            )
        }
    }

    private fun setStatusBarColor() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = resources.getColor(R.color.black)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

}

