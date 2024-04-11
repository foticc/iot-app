package com.foticc.iot.components.icon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foticc.iot.R


@Preview
@Composable
fun Demo(modifier: Modifier = Modifier) {

    Column {
        FontIcon(icon = FontIcons.dashboard)
        FontIcon(icon = FontIcons.checked_1)
        FontIcon(icon = FontIcons.material_symbols_air_rounded)
        FontIcon(icon = FontIcons.ic_round_chevron_left)
        FontIcon(icon = FontIcons.material_symbols_edit_sharp)
        FontIcon(icon = FontIcons.material_symbols_tv_rounded)
    }


}

@Composable
fun FontIcon(modifier: Modifier = Modifier,icon:FontIcon,size: Dp = 24.dp,tint: Color = Color.Unspecified) {

    val fontScale = LocalConfiguration.current.fontScale


    val scaleIndependentFontSize =
        scaleIndependentFontSize(sizeInDp = size, scaleFactor = fontScale)

    val textStyle = TextStyle(
        color = tint,
        fontFamily = FontFamily(Font(resId = R.font.icomoon)),
        fontSize = scaleIndependentFontSize
    )

    BasicText(
        text = icon.src.toChar().toString(),
        modifier = modifier,
        style = textStyle,
    )
}

private fun scaleIndependentFontSize(sizeInDp: Dp, scaleFactor: Float): TextUnit {
    val materialIconOffset = 3.dp
    return ((sizeInDp - materialIconOffset).value  / scaleFactor).sp
}



