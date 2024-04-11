package com.foticc.iot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foticc.iot.R


@Preview
@Composable
private fun PreviewSelectCover() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(6) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(171.dp)
                    .height(120.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp)),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = ""
            )
            Checkbox(
                modifier = Modifier.clip(RoundedCornerShape(13.dp)),
                checked = it % 2 == 0,
                onCheckedChange = {})
        }
    }
}