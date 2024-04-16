package com.foticc.iot.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewCardSelect() {
    var checked by remember {
        mutableStateOf(false)
    }
    Text(text = "${checked}")
    Checkbox(
        checked = checked,
        onCheckedChange = { newChecked ->
            checked = newChecked
        },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Black,
            uncheckedColor = Color.Black,
            checkmarkColor = Color.Black
        ),
        modifier = Modifier
            .size(24.dp) // 设置多选框的大小
            .clip(CircleShape) // 将多选框设置为圆形
    )

}
