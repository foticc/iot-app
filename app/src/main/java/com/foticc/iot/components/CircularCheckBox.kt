package com.foticc.iot.components;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircularCheckBox(checked: Boolean, enabled: Boolean = true, onChecked: () -> Unit) {
    val color = MaterialTheme.colorScheme
    val imageVector = if (checked) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle
    val tint = if (checked) color.primary.copy(alpha = 0.8f) else Color.White.copy(alpha = 0.8f)
    val background = if (checked) Color.White else Color.Black

    IconButton(onClick = { onChecked() },
        modifier = Modifier.offset(x = 4.dp, y = 4.dp),
        enabled = enabled) {

        Icon(imageVector = imageVector, tint = tint,
            modifier = Modifier.background(background, shape = CircleShape),
            contentDescription = "checkbox")
    }
}

@Preview
@Composable
private fun PreviewCircularCheckBox() {
    var selected by remember {
        mutableStateOf(false)
    }

    CircularCheckBox(checked = selected) {
        selected = !selected
    }
}
