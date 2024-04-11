package com.foticc.iot.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
private fun PrevOutlinedTextField() {
    var text by remember {
        mutableStateOf("")
    }
    CommonTextField(value = text) {
        text = it
    }
}

@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    val notNull by remember(value) {
//        derivedStateOf {
//            text.isNotEmpty()
//        }
        mutableStateOf(value.isNotEmpty())
    }
    OutlinedTextField(
        modifier = modifier,
        value = value,
        singleLine = true,
        trailingIcon = {
            if (notNull) {
                IconButton(onClick = { onValueChange.invoke("") }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear"
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color(0xff008B28),
            focusedBorderColor = Color(0xff008B28), // 修改聚焦时的边框颜色
            unfocusedBorderColor = Color(0xff008B28), // 修改未聚焦时的边框颜色
            disabledBorderColor = Color(0xff008B28), // 修改禁用时的边框颜色
            errorBorderColor = Color(0xff008B28) // 修改错误状态时的边框颜色
        ),
        onValueChange = onValueChange)

}
