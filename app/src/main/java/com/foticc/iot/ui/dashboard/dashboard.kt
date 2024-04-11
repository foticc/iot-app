package com.foticc.iot.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foticc.iot.components.SceneSwitch
import com.foticc.iot.components.SmallShowCard
import com.foticc.iot.components.icon.FontIcon
import com.foticc.iot.components.icon.FontIcons
import com.foticc.iot.ui.home.BottomItem

@Preview
@Composable
fun PrevDashboard() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Shortcut()
        Scenes()
        FrequentlyUsed()
    }

}


@Composable
fun Shortcut() {
    LazyRow {
        item {
            SmallShowCard(
                icon = { FontIcon(icon = FontIcons.material_symbols_tv_rounded) },
                mainText = "Smart TV",
                extra = "2 Active"
            )
            SmallShowCard(
                icon = { FontIcon(icon = FontIcons.material_symbols_lightbulb) },
                mainText = "Lights",
                extra = "2 Active"
            )
            SmallShowCard(
                icon = { FontIcon(icon = FontIcons.material_symbols_air_rounded) },
                mainText = "Air Purifier",
                extra = "1 On"
            )
        }
    }
}

@Composable
fun Scenes() {
    Column() {
        Text(text = "Scenes")
        LazyColumn {
            item {
                SceneSwitch(
                    modifier = Modifier.padding(vertical = 10.dp),
                    content = "Morning Scene"
                ) {
                    FontIcon(icon = FontIcons.ph_sun_fill)
                }
                SceneSwitch(
                    content = "Night Scene"
                ) {
                    Icon(imageVector = Icons.Rounded.Face, contentDescription = "face")
                }
            }
        }
    }

}

@Composable
fun FrequentlyUsed() {
    
}