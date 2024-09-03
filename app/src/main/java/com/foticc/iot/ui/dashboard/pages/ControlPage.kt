package com.foticc.iot.ui.dashboard.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.foticc.iot.components.FreeTextSlider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControlPage(navController: NavHostController) {

    var sliderValue by remember {
        mutableFloatStateOf(100f)
    }
    Column(modifier = Modifier.padding(top = 100.dp)) {

        Text(text = "back", modifier = Modifier.clickable {
            navController.popBackStack()
        })
        Text(text = "${sliderValue}")


        FreeTextSlider(
            modifier = Modifier,
            orientation = Orientation.Vertical,
            value = sliderValue,
            valueRange = 10f..100f,
            height = 60.dp,
            onValueChange = {
                sliderValue = it
            }
        )
        Text(text = "123556")
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PreviewControlPage() {
    val rememberNavController = rememberNavController()
    ControlPage(navController = rememberNavController)
}