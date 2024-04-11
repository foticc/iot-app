package com.foticc.iot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.atMost


@Preview
@Composable
private fun PreviewLayout() {
    val modifier = Modifier
        .width(100.dp)
        .height(100.dp)

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {
        // max 16 components
        val (b1, b2, b3) = createRefs()
        Box(modifier = modifier
            .background(Color.Black)
            .constrainAs(b1) {
                top.linkTo(parent.top)
            })
        Box(modifier = modifier
            .background(Color.Red)
            .constrainAs(b2) {
                start.linkTo(b1.end)
                top.linkTo(b1.bottom, margin = 100.dp)
            })
        Box(modifier = modifier
            .background(Color.Yellow)
            .constrainAs(b3) {
                top.linkTo(b2.bottom, margin = 100.dp)
                start.linkTo(b1.end, margin = 200.dp)
            })
    }
}

@Preview
@Composable
private fun PreviewSimpleLayout() {
    val modifier = Modifier
        .width(100.dp)
        .height(100.dp)

    BoxWithConstraints(modifier = Modifier.height(300.dp)) {
        val definedConstraintSet = if (minHeight < 300.dp) {
            definedConstraintSet(20.dp)
        } else {
            definedConstraintSet(50.dp)
        }


        ConstraintLayout(
            modifier = Modifier.fillMaxSize(), constraintSet = definedConstraintSet
        ) {
            // max 16 components
            Box(
                modifier = modifier
                    .background(Color.Black)
                    .layoutId("b1")
            )
            Box(
                modifier = modifier
                    .background(Color.Red)
                    .layoutId("b2")
            )
            Box(
                modifier = modifier
                    .background(Color.Yellow)
                    .layoutId("b3")
            )
        }
    }

}

private fun definedConstraintSet(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val b1 = createRefFor("b1")
        val b2 = createRefFor("b2")
        val b3 = createRefFor("b3")

        constrain(b1) {
            top.linkTo(parent.top)
        }
        constrain(b2) {
            start.linkTo(b1.end)
            top.linkTo(b1.bottom, margin = margin)
        }

        constrain(b3) {
            top.linkTo(b2.bottom, margin = margin)
            start.linkTo(b1.end, margin = margin)
        }

    }
}


@Preview
@Composable
private fun PreviewSimple() {
    val modifier = Modifier
        .width(100.dp)
        .height(100.dp)

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {

        val createGuidelineFromStart = createGuidelineFromStart(10f)

        // max 16 components
        val (b1, b2, b3) = createRefs()
        Box(modifier = modifier
            .background(Color.Black)
            .constrainAs(b1) {
                top.linkTo(parent.top)
            })
        Box(modifier = modifier
            .background(Color.Red)
            .constrainAs(b2) {
                start.linkTo(b1.end)
                top.linkTo(b1.bottom, margin = 100.dp)
            })
        Box(modifier = modifier
            .background(Color.Yellow)
            .constrainAs(b3) {
                top.linkTo(b2.bottom, margin = 100.dp)
                start.linkTo(b1.end, margin = 200.dp)
            })
    }
}