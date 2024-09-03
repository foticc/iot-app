package com.foticc.iot.ui.profiles

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.foticc.iot.components.AvatarDemo
import com.foticc.iot.components.Material3Card
import com.foticc.iot.components.SettingCardDemo
import com.foticc.iot.ui.home.toast
import com.foticc.iot.ui.profiles.items.ProfileDetails
import com.foticc.iot.ui.theme.IotappTheme

@Preview(showSystemUi = true)
@Composable
private fun PreviewProfile() {
    IotappTheme {
        Profiles()
    }
}


@Composable
fun Profiles() {
    val navController = rememberNavController()
    val context = LocalContext.current;
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            ProfilesMain(context = context, navController = navController)
        }
        composable("detail") {
            ProfileDetails()
        }
    }
}

@Composable
private fun ProfilesMain(context:Context,navController:NavHostController) {
    Column(modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround) {
        AvatarDemo()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileCard(icon = Icons.Rounded.Person, text = "Profile details"){
            context.toast("Profile details")
            navController.navigate("detail")
        }
        Spacer(modifier = Modifier.height(16.dp))

        ProfileCard(icon = Icons.Rounded.Settings, text = "Settings"){
            context.toast("Settings")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ProfileCard(icon = Icons.Rounded.Notifications, text = "Push Notifications"){
            context.toast("Push Notifications")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ProfileCard(icon = Icons.Rounded.Build, text = "Support"){
            context.toast("Support")
        }
        Spacer(modifier = Modifier.height(16.dp))

        ProfileCard(icon = Icons.Rounded.ExitToApp, text = "Logout"){
            context.toast("Logout")
        }
        Spacer(modifier = Modifier.height(100.dp))

    }
}


@Composable
fun ProfileCard(icon:ImageVector,text:String,onClick:()->Unit) {
    Material3Card(modifier = Modifier
        .fillMaxWidth()
        .height(64.dp)) {
        val padding = Modifier.padding(start = 16.dp)
        Row(
            modifier = Modifier.clickable(onClick=onClick),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = padding,
                imageVector = icon, contentDescription = text
            )
            Text(
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(1f),
                textAlign = TextAlign.Start,
                text = text
            )
            IconButton(modifier = padding.padding(end = 16.dp),
                onClick = onClick) {
                Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "ArrowForward")
            }

        }
    }
}