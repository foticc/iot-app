package com.foticc.iot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(name = "Scene")
@Composable
fun SceneSwitch() {
    var checked by remember {
        mutableStateOf(false)
    }
    Material3Card(
        modifier = Modifier
            .width(358.dp)
            .height(64.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.padding(start = 16.dp)) {
                Icon(
                    imageVector = Icons.Rounded.AccountBox,
                    contentDescription = "ThumbUp"
                )
            }
            Text(modifier = Modifier.padding(start = 16.dp), text = "Morning scene")
            Switch(modifier = Modifier.padding(start = 16.dp, end = 16.dp), checked = checked,
                colors = SwitchDefaults.colors(checkedThumbColor = Color.Blue),
                onCheckedChange = {
                    checked = !checked
                })

        }
    }
}

@Preview(name = "Frequently Used")
@Composable
fun Complex() {
    var checked by remember {
        mutableStateOf(false)
    }
    Material3Card(
        modifier = Modifier
            .width(171.dp)
            .height(116.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .width(139.dp)
                    .height(32.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountBox,
                    contentDescription = "ThumbUp"
                )
                Switch(modifier = Modifier, checked = checked,
                    colors = SwitchDefaults.colors(checkedThumbColor = Color.Blue),
                    onCheckedChange = {
                        checked = !checked
                    })

            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .width(139.dp)
                    .height(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(modifier = Modifier.padding(start = 16.dp), text = "Smart TV")
                Text(modifier = Modifier.padding(start = 16.dp), text = "1 Device")
            }

        }
    }
}

@Preview
@Composable
fun CustomSwith() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(modifier = Modifier, checked = checked,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.White,
            uncheckedIconColor = Color.White,
            uncheckedBorderColor = Color.Black,
            uncheckedTrackColor = Color.Black,

            checkedThumbColor = Color.White,
            checkedIconColor = Color.White,
            checkedBorderColor = Color.Green,
            checkedTrackColor = Color.Green
        ),
        onCheckedChange = {
            checked = !checked
        })
}

