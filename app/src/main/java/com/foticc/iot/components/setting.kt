package com.foticc.iot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foticc.iot.ui.theme.IotappTheme

@Preview
@Composable
fun SettingCardDemo() {
    
    Material3Card {
        val padding = Modifier.padding(start = 16.dp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = padding,
                imageVector = Icons.Rounded.Person, contentDescription = "setting"
            )
            Text(
                modifier = padding,
                text = "Profile Details"
            )
            IconButton(modifier = padding.padding(end = 16.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.ArrowForward, contentDescription = "ArrowForward")
            }

        }
    }

}