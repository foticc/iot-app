package com.foticc.iot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewButton() {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 40.dp)
                .align(Alignment.Start), text = "Room Name"
        )
        CommonTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp), value = text
        ) {
            text = it
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 102.dp)
                .background(
                    color = Color(color = 0XFF34E0A1),
                    shape = RoundedCornerShape(12.dp)

                ),
            onClick = { /*TODO*/ }) {
            Text(text = "Continue")
        }
        Text(
            text = "Back",
            color = Color(color = 0xff34E0A1),
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {

                })
    }
}