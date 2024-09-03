package com.foticc.iot.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
@Preview(showSystemUi = true)
@Composable
fun CustomSliderDemo() {
    var sliderValue by remember {
        mutableFloatStateOf(100f)
    }
    Text(text = "${sliderValue}")
    Slider(
        modifier = Modifier
            .rotate(90f)
            .height(60.dp),
        value = sliderValue,
        valueRange = 10f..100f,
        onValueChange = {
            sliderValue = it
        },
        thumb = {},
        track = {
            CustomTrack(sliderPositions = it, sliderValue = sliderValue)
        }


    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeTextSlider(
    modifier: Modifier = Modifier,
    value: Float,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChange: (Float) -> Unit,
    enabled: Boolean = true,
    orientation: Orientation = Orientation.Horizontal,
    onValueChangeFinished: (() -> Unit)? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    height: Dp,
) {
    val fl = when (orientation) {
        Orientation.Horizontal -> 0f
        Orientation.Vertical -> 270f
    }
    Box(
        modifier = Modifier
            .width(12.dp)
            .height(height), contentAlignment = Alignment.Center
    ) {
        Slider(
            modifier = modifier
                .rotate(fl)
                .height(height),
            value = value,
            valueRange = valueRange,
            onValueChange = onValueChange,
            enabled = enabled,
            onValueChangeFinished = onValueChangeFinished,
            thumb = {},
            track = {
                CustomTrack(
                    modifier = Modifier.rotate(fl),
                    sliderPositions = it,
                    sliderValue = value,
                    fontSize = fontSize,
                    fontStyle = fontStyle
                )
            }
        )
    }

}

@Composable
private fun CustomTrack(
    sliderPositions: SliderPositions,
    sliderValue: Float,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    colors: SliderColors = SliderDefaults.colors(),
    enabled: Boolean = true,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Canvas(
            modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(5.dp))
        ) {
            val isRtl = layoutDirection == LayoutDirection.Rtl
            val sliderLeft = Offset(0f, center.y)
            val sliderRight = Offset(size.width, center.y)
            val sliderStart = if (isRtl) sliderRight else sliderLeft
            val sliderEnd = if (isRtl) sliderLeft else sliderRight
            val tickSize = 1.dp.toPx()
            val trackStrokeWidth = size.height.dp.toPx()
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
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "${sliderValue.toInt()}",
            textAlign = TextAlign.Center,
            fontSize = fontSize,
            fontStyle = fontStyle
        )
    }
}




