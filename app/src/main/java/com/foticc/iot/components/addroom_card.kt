package com.foticc.iot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.foticc.iot.components.icon.FontIcon
import com.foticc.iot.components.icon.FontIcons

@Preview
@Composable
private fun PreviewCard() {
    var checked by remember {
        mutableStateOf(false)
    }
    Material3Card {
        Column(modifier = Modifier) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FontIcon(icon = FontIcons.material_symbols_tv_rounded)
                Checkbox(checked = checked, onCheckedChange = {
                    checked=it
                })
            }
            Text(text = "Smart TV")
        }
    }
}