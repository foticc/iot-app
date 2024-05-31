package com.foticc.iot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.foticc.iot.components.icon.FontIcon
import com.foticc.iot.components.icon.FontIcons
import com.foticc.iot.ui.home.Home
import com.foticc.iot.ui.theme.CardColor
import com.foticc.iot.ui.theme.IotappTheme

@Preview
@Composable
fun PrevSceneSwitch() {
    SceneSwitch(
        content = "Morning Scene"
    ) {
        FontIcon(icon = FontIcons.ph_sun_fill)
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun PrevComplex() {
    MiddleCard()
}

@Composable
fun SceneSwitch(
    modifier: Modifier = Modifier,
    content: String,
    prefix: @Composable BoxScope.() -> Unit,
) {
    var checked by remember {
        mutableStateOf(false)
    }
    Material3Card(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.padding(start = 16.dp), content = prefix)
            Text(modifier = Modifier.padding(start = 16.dp), text = content)
            CustomSwitch(modifier = Modifier.padding(start = 16.dp, end = 16.dp), checked = checked,
                onCheckedChange = {
                    checked = !checked
                })

        }
    }
}

@Composable
fun MiddleCard() {
    var checked by remember {
        mutableStateOf(false)
    }
    Material3Card(
        modifier = Modifier
            .width(171.dp)
            .height(116.dp),
        backgroundColor = CardColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .width(139.dp)
                    .height(32.dp),
            ) {
                Icon(
                    modifier = Modifier.weight(1f),
                    imageVector = Icons.Rounded.AccountBox,
                    contentDescription = "ThumbUp"
                )
                CustomSwitch(modifier = Modifier.weight(1f), checked = checked,
                    onCheckedChange = {
                        checked = !checked
                    })

            }
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .width(139.dp)
                    .height(46.dp)
                    .padding(bottom = 2.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(modifier = Modifier, text = "Smart TV")
                Text(modifier = Modifier, text = "1 Device")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevCustomSwitch() {
    var checked by remember {
        mutableStateOf(false)
    }
    CustomSwitch(checked = checked) {
        checked = !checked
    }
}

@Composable
fun CustomSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {
    Switch(
        modifier = modifier, checked = checked,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.White,
            uncheckedIconColor = Color.White,
            uncheckedBorderColor = Color.Black,
            uncheckedTrackColor = Color.Black,

            checkedThumbColor = Color.White,
            checkedIconColor = Color.White,
            //当 Switch 启用且选中时，边框（border）的颜色。
            checkedBorderColor = MaterialTheme.colorScheme.onPrimary,
            checkedTrackColor = MaterialTheme.colorScheme.onPrimary
        ),
//        thumbContent = {
//            if (checked) {
//                Text(text = "123", color = Color.Blue)
//            }else{
//                Text(text = "456",color = Color.Blue)
//            }
//        },
        onCheckedChange = onCheckedChange
    )
}


