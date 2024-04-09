package com.foticc.iot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SliderDemo() {
    var sliderValue by remember {
        mutableFloatStateOf(10f)
    }
    Slider(value = sliderValue,
        valueRange = 10f..100f,
        onValueChange = {
            sliderValue = it
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CustomSliderDemo() {
    var sliderValue by remember {
        mutableFloatStateOf(30f)
    }
    Slider(
        value = sliderValue,
        valueRange = 10f..100f,
        onValueChange = {
            sliderValue = it
        },
        colors = SliderDefaults.colors(
            thumbColor= Color.Green,
            activeTickColor = Color.Yellow,
            activeTrackColor = Color.Green,
            inactiveTrackColor = Color.Red
        ),
        thumb = {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "edit")
        }

    )
}

