package com.foticc.iot.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val route:String,val title:String,val icon:ImageVector) {

    object Dashboard:BottomItem("/dashboard","Dashboard",Icons.Default.DateRange)
    object Rooms:BottomItem("/rooms","Rooms",Icons.Default.Menu)
    object Profiles:BottomItem("/profiles","Profiles",Icons.Default.Person)

}