package com.lixoten.fido.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lixoten.fido.presentation.fourth_screen.FourthScreen
import com.lixoten.fido.presentation.fourth_screen.FourthScreenDestination
import com.lixoten.fido.presentation.home_screen.HomeScreen
import com.lixoten.fido.presentation.home_screen.HomeScreenDestination
import com.lixoten.fido.presentation.item_detail_screen.ItemDetailScreen
import com.lixoten.fido.presentation.item_detail_screen.ItemDetailScreenDestination
import com.lixoten.fido.presentation.list_screen.ListScreen
import com.lixoten.fido.presentation.list_screen.ListScreenDestination

@Composable
fun FidoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeScreenDestination.route) {
            HomeScreen(
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
        composable(route = ListScreenDestination.route) {
            ListScreen(
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
        composable(
            route = ItemDetailScreenDestination.route + "?myId={myId}",
            arguments = listOf(
                navArgument(
                    "myId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { navBackStackEntry ->

            val myInt =
                navBackStackEntry.arguments?.getInt("myId")


            ItemDetailScreen(
                myInt = myInt ?: 0,
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
        composable(
            route = FourthScreenDestination.route + "?myText={text}",
            arguments = listOf(
                navArgument(
                    "text"
                ) {
                    type = NavType.StringType
                    //nullable = true
                    defaultValue = "zbbb"
                }
            )
        ) { navBackStackEntry ->

            val myStrg =
                navBackStackEntry.arguments?.getString("text")

            FourthScreen(
                myStrg = myStrg ?: "xx",
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
    }
}