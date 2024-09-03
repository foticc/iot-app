package com.foticc.iot.ui.profiles.items

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.foticc.iot.components.CommonTextField
import com.foticc.iot.ui.theme.IotappTheme
import javax.sql.RowSetWriter

@Preview(showSystemUi = true)
@Composable
private fun PreviewProfileDetails() {
    IotappTheme {
        ProfileDetails()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetails() {
    var text by remember {
        mutableStateOf("")
    }
    val rememberDatePickerState = rememberDatePickerState()

    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "Profile details"
                )
                Text(text = "Profile details")
            }
        })
    }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonTextField(placeholder = { Text(text = "no")},value = text) {
                text = it
            }
            CommonTextField(value = text) {
                text = it
            }
            CommonTextField(value = text) {
                text = it
            }
            CommonTextField(value = text) {
                text = it
            }
            CommonTextField(value = text) {
                text = it
            }
            CommonTextField(value = text) {

            }
        }

    }
}