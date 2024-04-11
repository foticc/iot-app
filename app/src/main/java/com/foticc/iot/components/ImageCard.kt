package com.foticc.iot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foticc.iot.R

@Preview
@Composable
private fun PreviewImageCard() {
    Material3Card(
    ) {
        Column(modifier = Modifier.width(358.dp).height(223.dp)) {
            Image(
                modifier = Modifier.height(159.dp).fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription ="image" )
            Row(modifier = Modifier.padding(all=16.dp)) {
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.Notifications, contentDescription = "add")
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.ThumbUp, contentDescription = "ThumbUp")
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.Face, contentDescription = "Face")
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.Info, contentDescription = "Info")
            }
        }

    }
}