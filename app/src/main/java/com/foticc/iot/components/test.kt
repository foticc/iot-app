package com.foticc.iot.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview
fun Example() {
    var valueA by remember { mutableStateOf(0) }
    var valueB by remember { mutableStateOf(0) }


     SideEffect {
           Log.d("重组观察","最外层容器进行了重组")
          }

     Column {
           ComposableContainerA(text = "$valueA")
           ComposableContainerB(text = "$valueB")
           Row {
             Button(onClick = { valueA++ }) {
               Text("A值加1")
              }

             Button(onClick = { valueB++ }) {
               Text("B值加1")
              }
            }
          }

}

@Composable
private fun ComposableContainerA(
     text: String,
) {

     SideEffect {
           Log.d("重组观察", "重组作用域A进行了重组")
          }

    ConstraintLayout(modifier = Modifier
        .background(Color.Black)
        .padding(10.dp)) {
        Text(
            text = "我是重组作用域A，当前值${text}",
            color = Color.White
        )
        ComposableBoxA()
    }


}

@Composable
private fun ComposableBoxA() {
     SideEffect {
           Log.d("重组观察", "重组作用域A内部的容器进行了重组")
          }
     Text("我是A容器的内部组件", color = Color.White, modifier = Modifier.background(Color.Gray))
}

@Composable
private fun ComposableContainerB(
     text: String,
) {

     SideEffect {
           Log.d("重组观察", "重组作用域B进行了重组")
          }

     Box(
         Modifier
             .background(Color.Red)
             .padding(10.dp)
      ) {
           Text(
             text = "我是重组作用域B，当前值${text}",
             color = Color.White
            )
          }
}

