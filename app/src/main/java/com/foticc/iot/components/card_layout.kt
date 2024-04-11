package com.foticc.iot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Preview
@Composable
private fun PreviewMiddleCardLayout() {
    var checked by remember {
        mutableStateOf(false)
    }
    Material3Card(
        modifier = Modifier
            .width(171.dp)
            .height(116.dp),
        backgroundColor = Color(0xFFF7F7F7)
    ) {

        BoxWithConstraints(modifier = Modifier) {
            val definedConstraintSet = definedConstraintSet()
            ConstraintLayout(modifier = Modifier.fillMaxSize(),constraintSet = definedConstraintSet) {
                Icon(
                    modifier = Modifier.layoutId("icon"),
                    imageVector = Icons.Rounded.ThumbUp,
                    contentDescription = "ThumbUp"
                )
                Switch(
                    modifier = Modifier.layoutId("switch"),
                    checked = checked,
                    colors = SwitchDefaults.colors(checkedThumbColor = Color.Blue),
                    onCheckedChange = {
                        checked = !checked
                    })
                Text(modifier = Modifier.layoutId("label"), text = "Smart TV")
                Text(modifier = Modifier.layoutId("status"), text = "1 Device")
            }
        }
    }
}

private fun definedConstraintSet(): ConstraintSet {
    val padding = 16.dp
    return ConstraintSet {
        val icon = createRefFor("icon")
        val switch = createRefFor("switch")
        val label = createRefFor("label")
        val status = createRefFor("status")
        constrain(icon) {
            start.linkTo(parent.start, margin = padding)
            top.linkTo(parent.top,margin = padding)
        }
        constrain(switch) {
            top.linkTo(parent.top, margin = padding)
            end.linkTo(parent.end, margin = padding)
        }
        constrain(label) {
            top.linkTo(icon.bottom, margin = padding)
            start.linkTo(parent.start, margin = padding)
        }
        constrain(status) {
            top.linkTo(label.bottom, margin = 2.dp)
            start.linkTo(parent.start, margin = padding)
        }

//        constrain(b1) {
//            top.linkTo(parent.top)
//        }
//        constrain(b2) {
//            start.linkTo(b1.end)
//            top.linkTo(b1.bottom, margin = 100.dp)
//        }
//
//        constrain(b3) {
//            top.linkTo(b2.bottom, margin = margin)
//            start.linkTo(b1.end, margin = margin)
//        }

    }
}