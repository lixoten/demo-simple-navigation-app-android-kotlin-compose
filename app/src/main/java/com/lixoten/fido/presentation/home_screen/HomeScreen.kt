package com.lixoten.fido.presentation.home_screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lixoten.fido.R
import com.lixoten.fido.navigation.NavigationDestination
import com.lixoten.fido.presentation.list_screen.ListScreenDestination

object HomeScreenDestination : NavigationDestination {
    override val route = "home_scr"

    @StringRes
    override val titleRes = R.string.home_screen_name
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You are in Home Screen",
            fontSize = 24.sp
        )
        Button(
            onClick = {
                navController.navigate(
                    ListScreenDestination.route
                )
            }
        ) {
            Text(text = stringResource(id = R.string.list_screen_button))
        }
    }
}