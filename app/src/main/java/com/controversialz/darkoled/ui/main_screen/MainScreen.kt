package com.controversialz.darkoled.ui.main_screen

import android.os.Process
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.controversialz.darkoled.R
import kotlinx.coroutines.launch

@Composable
fun MainScreen(onApplyClicked: () -> Unit, showMessage: LiveData<String>) {
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
                onClick = { Process.killProcess(Process.myPid()) },
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
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(28.dp, 28.dp)
                        .align(Alignment.CenterVertically),
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