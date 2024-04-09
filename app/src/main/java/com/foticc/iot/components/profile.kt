package com.foticc.iot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.foticc.iot.R

@Preview(name = "avatar", showSystemUi = false)
@Composable
fun AvatarDemo() {
    Box(
        modifier = Modifier
            .padding(0.dp)
            .size(110.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "avatar",
            modifier = Modifier
                .fillMaxSize()
                .border(width = 2.dp, color = Color(0xff34E0A1), shape = CircleShape)
                .clip(CircleShape)
                .matchParentSize()
        )
        IconButton(modifier = Modifier.align(Alignment.BottomEnd),
            onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xff34E0A1)),
                imageVector = Icons.Default.Edit,
                contentDescription = "edit"
            )
        }

    }
}

@Preview
@Composable
fun Example23() {
    Box(
        modifier = Modifier.size(100.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        // 这是第一个元素
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Blue)
//        )

        // 这是第二个元素，放在第一个元素的右下角
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Red)
                .align(Alignment.BottomEnd)
        )
    }
}