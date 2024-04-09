package com.foticc.iot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SwipeButton() {
    val remember = remember { MutableInteractionSource() }


    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .height(130.dp)
            .width(20.dp)
            .background(Color.DarkGray)
//        shape = RoundedCornerShape(5.dp)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .background(Color.White)
                .clip(RoundedCornerShape(5.dp))
                .fillMaxWidth(1f)
                .fillMaxHeight(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "88",
                textAlign = TextAlign.Center,
            )
        }
    }
}


