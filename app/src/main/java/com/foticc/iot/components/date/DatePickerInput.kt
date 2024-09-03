package com.foticc.iot.components.date

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerInput(onDismissRequest: (() -> Unit)? = null, confirm: (timestamp: Long) -> Unit) {

    val rememberDatePickerState = rememberDatePickerState()

    DatePickerDialog(onDismissRequest = { onDismissRequest?.invoke() }, confirmButton = {
        TextButton(onClick = {
            rememberDatePickerState.selectedDateMillis?.let { confirm.invoke(it) }
        }) {
            Text(text = "确定")
        }
    }) {
        DatePicker(state = rememberDatePickerState)
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PreviewDatePickerInput2() {
    var dialogState by remember {
        mutableStateOf(false)
    }
    var timestamp by remember {
        mutableStateOf<Long?>(null)
    }
    Column {
        Text(text = "open", modifier = Modifier.clickable {
            dialogState = true
        })
        Text(text = timestamp.toString())
    }

    if (dialogState) {
        DatePickerInput {
            timestamp = it
            dialogState = false
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
private fun PreviewDatePicker() {

    val coroutineScope = rememberCoroutineScope()

    var dialogState by remember {
        mutableStateOf(false)
    }
    val rememberDatePickerState = rememberDatePickerState()

    var timeDialogState by remember {
        mutableStateOf(false)
    }
    val rememberTimePickerState = rememberTimePickerState()

    Column {
        Text(text = "OpenDatePicker", modifier = Modifier.clickable {
            dialogState = true
        })
        Text(text = rememberDatePickerState.selectedDateMillis.toString())
        Text(text = "OpenTimePicker", modifier = Modifier.clickable {
            timeDialogState = true
        })
        Text(text = "${rememberTimePickerState.hour}:${rememberTimePickerState.minute}")
    }

    if (dialogState) {
        DatePickerDialog(onDismissRequest = { dialogState = false }, confirmButton = {
            TextButton(onClick = { dialogState = false }) {
                Text(text = "确定")
            }
        }) {
            DatePicker(state = rememberDatePickerState)
        }
    }

    if (timeDialogState) {
        AlertDialog(
            text = {
                TimePicker(state = rememberTimePickerState)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        timeDialogState = false
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Ok")
                }
            },
            onDismissRequest = {
                timeDialogState = false
            },
            shape = RoundedCornerShape(16.dp)
        )
    }






}