package com.foticc.iot.ui.rooms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foticc.iot.R
import com.foticc.iot.components.Material3Card
import com.foticc.iot.ui.theme.IotappTheme


@Preview(showSystemUi = true)
@Composable
private fun PreviewRooms() {
    IotappTheme {
        RoomsPages()
    }
}

@Composable
fun RoomsPages() {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        items(88) {
            RoomCard(){
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.Notifications, contentDescription = "add")
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.ThumbUp, contentDescription = "ThumbUp")
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.Face, contentDescription = "Face")
                Icon(modifier = Modifier.padding(start =8.dp),imageVector = Icons.Rounded.Info, contentDescription = "Info")
            }
        }
    }
}


@Composable
fun RoomCard(image: String = "http://127.0.0.1/image/url",content: @Composable RowScope.() -> Unit) {
    Material3Card(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 24.dp)
    ) {
        Column(modifier = Modifier
//            .width(358.dp)
            .fillMaxWidth()
            .height(223.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .height(159.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription ="image" )
                Text(
                    text = "Living Room",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp) // Adjust padding as needed
                )
            }

            Row(modifier = Modifier.padding(all=16.dp),content=content)
        }

    }
}