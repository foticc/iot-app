package com.foticc.iot.demo

import android.content.Context
import android.os.Build
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
private fun PreviewKeyBoard() {
    val context = LocalContext.current;
    var index by remember {
        mutableIntStateOf(0)
    }
    val code = remember {
        mutableStateListOf<Int>(*IntArray(10){-1}.toTypedArray())
    }

    Column {
        Row {
            for (i in code) {
                if (i == -1) {
                    Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        color = Color.Gray,
                        text = 0.toString())
                }else {
                    Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        color = Color.Black,
                        text = i.toString())
                }
            }
        }

        LazyVerticalGrid(columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.Center,
            userScrollEnabled = false
        ) {
            items(items = arrayOf(1,2,3,4,5,6,7,8,9,null,0,null)) {
                if(it!=null) {
                    SingleKeys(onClick = {
                        context.vibrator()
                        code.set(index,it).also {
                            if (index < code.size-1) {
                                index += 1
                            }else {
                                index = 0
                            }
                        }
                    }, text = it.toString())
                }
            }
        }
    }



}



@Composable
fun SingleKeys(onClick:()->Unit,text:String) {
    TextButton(onClick = onClick) {
        Text(text = text)
    }
}


fun Context.vibrator() {
    val defaultVibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }
    defaultVibrator.cancel()
    defaultVibrator.vibrate(100)
}
