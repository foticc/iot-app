package com.foticc.iot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.foticc.iot.R

@Preview(name = "avatar")
@Composable
fun AvatarDemo() {
   Box(modifier = Modifier.clip(CircleShape)) {
      Image(painter = painterResource(id = R.drawable.freecompress), contentDescription = "123")
      IconButton(onClick = { /*TODO*/ }) {
         Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
      }
   }
}