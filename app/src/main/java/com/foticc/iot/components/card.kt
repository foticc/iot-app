package com.foticc.iot.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.foticc.iot.components.icon.FontIcon
import com.foticc.iot.components.icon.FontIcons


@Preview
@Composable
fun Demo() {
    SmallShowCard(
        icon = { FontIcon(icon = FontIcons.material_symbols_tv_rounded) }, mainText = "Smart TV",
        extra = "2 Active"
    )
}

@Composable
fun SmallShowCard(
    icon: @Composable BoxScope.() -> Unit,
    mainText: String,
    extra: String,
) {
    Material3Card(
        modifier = Modifier
            .padding(10.dp)
            .width(119.dp)
            .height(50.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                content = icon
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = mainText)
                Text(text = extra)
            }

        }
    }
}

@Composable
fun Material3Card(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = elevation,
        shadowElevation = elevation,
        border = border,
        content = content
    )
}