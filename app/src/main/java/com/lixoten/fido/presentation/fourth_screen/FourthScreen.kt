package com.lixoten.fido.presentation.fourth_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lixoten.fido.R
import com.lixoten.fido.navigation.Screen

//object FourthScreenDestination : NavigationDestination {
//    override val route = "fourth_scr"
//
//    @StringRes
//    override val titleRes = R.string.fourth_screen_name
//
//    const val routeArg = "?myText="
//    val routeWithArgs = "$route$routeArg"
//}

@Composable
fun FourthScreen(
    myStrg: String?,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You are in Fourth Screen",
            fontSize = 24.sp
        )

        Text(
            text = "Received the String: $myStrg",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                navController.popBackStack(
                    //HomeScreenDestination.route,
                    Screen.Home.route,
                    inclusive = false)
            }
        ) {
            Text(text = stringResource(id = R.string.home_screen_button))
        }
    }
}