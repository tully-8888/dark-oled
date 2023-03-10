package com.controversialz.darkoled

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Dimension.Companion.DP
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.controversialz.darkoled.ui.theme.DarkOledTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
               MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier
            .padding(top = 20.dp, start = 6.dp, end = 6.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(28.dp,28.dp),
                    tint = Color.Black)
            }
            Text(text = "DarkOLED", color = Color.White, fontSize = 24.sp)

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Menu",
                    modifier = Modifier.size(28.dp,28.dp),
                    tint = Color.Black)
            }
        }
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_phone) ,
                contentDescription = "Menu",
                modifier = Modifier
                    .size(400.dp, 400.dp)
                    .align(Alignment.CenterHorizontally),
                tint = Color.Yellow,
            )
            Button(onClick = { /*TODO*/ }, modifier = Modifier.align(CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(28.dp, 28.dp)
                        .align(CenterVertically),
                    tint = Color.Black)
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
            tint = Color.Yellow,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
       MainScreen()
    }