package com.foticc.iot.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
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
        mutableFloatStateOf(100f)
    }
    Text(text = "${sliderValue}")
    Slider(
        modifier = Modifier
            .rotate(-90f)
            .fillMaxSize(),
        value = sliderValue,
        valueRange = 10f..100f,
        onValueChange = {
            sliderValue = it
        },
        thumb = {},
        track = {
            CustomTrack(sliderPositions = it,sliderValue)
        }


    )
}

@Composable
fun CustomTrack(sliderPositions: SliderPositions,
                sliderValue:Float,
                modifier: Modifier = Modifier,
                colors: SliderColors = SliderDefaults.colors(),
                enabled: Boolean = true) {
    Canvas(
        modifier
            .fillMaxWidth()
            .height(20.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        val isRtl = layoutDirection == LayoutDirection.Rtl
        val sliderLeft = Offset(0f, center.y)
        val sliderRight = Offset(size.width, center.y)
        val sliderStart = if (isRtl) sliderRight else sliderLeft
        val sliderEnd = if (isRtl) sliderLeft else sliderRight
        val tickSize = 1.dp.toPx()
        val trackStrokeWidth = 20.dp.toPx()
        drawLine(
            Color.White,
            sliderStart,
            sliderEnd,
            trackStrokeWidth,
            StrokeCap.Butt
        )
        val sliderValueEnd = Offset(
            sliderStart.x +
                    (sliderEnd.x - sliderStart.x) * sliderPositions.activeRange.endInclusive,
            center.y
        )

        val sliderValueStart = Offset(
            sliderStart.x +
                    (sliderEnd.x - sliderStart.x) * sliderPositions.activeRange.start,
            center.y
        )

        drawLine(
            color = Color(0xff2AB381),
            sliderValueStart,
            sliderValueEnd,
            trackStrokeWidth,
        )
        sliderPositions.tickFractions.groupBy {
            it > sliderPositions.activeRange.endInclusive ||
                    it < sliderPositions.activeRange.start
        }.forEach { (outsideFraction, list) ->
            drawPoints(
                list.map {
                    Offset(lerp(sliderStart, sliderEnd, it).x, center.y)
                },
                PointMode.Points,
//                (if (outsideFraction) inactiveTickColor else activeTickColor).value,
                Color.Yellow,
                tickSize,
                StrokeCap.Round
            )
        }
    }
    Text(text = "${sliderValue.toInt()}",modifier = Modifier.rotate(90f))
}




