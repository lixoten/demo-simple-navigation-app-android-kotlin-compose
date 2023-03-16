package com.lixoten.fido.presentation.item_detail_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lixoten.fido.navigation.Screen

//object ItemDetailScreenDestination : NavigationDestination {
//    override val route = "item_detail_scr"
//
//    @StringRes
//    override val titleRes = R.string.item_detail_screen_name
//
//    const val routeArg = "?myId="
//
//    val routeWithArgs = "$route$routeArg"
//}

@Composable
fun ItemDetailScreen(
    myInt: Int?,
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    val (text, setText) = remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You are in Item Detail Screen",
            fontSize = 24.sp
        )
        Text(
            text = "Received the Integer: $myInt",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = text,
            onValueChange = setText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(
            onClick = {
                navController.navigate(
                    Screen.Fourth.routeWithArgs+text
                    //FourthScreenDestination.routeWithArgs+text
                    //"fourth_scr" + "?myText=${text}"
                )
            }
        ) {
            Text(text = "Go to fourth screen")
        }
    }
}