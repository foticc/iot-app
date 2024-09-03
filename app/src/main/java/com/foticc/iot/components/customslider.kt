package com.foticc.iot.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


//@Preview(showSystemUi = true)
@Composable
private fun PreviewSwipeButtonLayout() {
    Column {
        Text(text = "line 1")
        SwipeButton()
        Text(text ="line end")
    }
}


@Preview
@Composable
fun SwipeButton() {
    val remember = remember { MutableInteractionSource() }


    

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .height(130.dp)
            .width(20.dp)
            .background(Color.DarkGray)
//        shape = RoundedCornerShape(5.dp)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .background(Color.White)
                .clip(RoundedCornerShape(5.dp))
                .fillMaxWidth(1f)
                .fillMaxHeight(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${maxHeight.value}",
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Preview
@Composable
private fun Demo123() {
    var offset by remember {
        mutableFloatStateOf(0f)
    }
    val boxSideLengthDp = 50.dp
    val boxSildeLengthPx = with(LocalDensity.current) {
        boxSideLengthDp.toPx()
    }

    val draggableState =  rememberDraggableState {
        offset = (offset + it).coerceIn(0f, 3 * boxSildeLengthPx)
    }
    Box(
        Modifier
            .width(boxSideLengthDp * 4)
            .height(boxSideLengthDp)
            .background(Color.LightGray)
    ) {
        Box(
            Modifier
                .fillMaxHeight()
                .width(Dp(offset))
//                .size(Dp(offset))
//                .offset {
//                    IntOffset(offset.roundToInt(), 0)
//                }
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = draggableState
                )
                .background(Color.DarkGray)

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
    Box(modifier =Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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


