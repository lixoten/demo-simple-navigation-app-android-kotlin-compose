package com.lixoten.fido.presentation.list_screen

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.lixoten.fido.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lixoten.fido.data.InitialData
import com.lixoten.fido.model.Item
import com.lixoten.fido.navigation.NavigationDestination
import com.lixoten.fido.presentation.item_detail_screen.ItemDetailScreenDestination

object ListScreenDestination : NavigationDestination {
    override val route = "list_scr"

    @StringRes
    override val titleRes = R.string.app_name
}

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val myItems = InitialData.getItems()

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You are in List Screen",
            fontSize = 24.sp
        )

        Text(text = "Click on an item to go detail screen, we pass myId Integer")

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "item_detail_scr?myId={myId}")

        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Items",
                    style = MaterialTheme.typography.h4
                )
            }
            Spacer(modifier = Modifier.height(4.dp))


            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                itemsIndexed(
                    items = myItems,
                ) { index, item ->
                    MyItem(
                        item = item,
                        onItemClick = {
                            navController.navigate(
                                ItemDetailScreenDestination.routeWithArgs + "${it.id}"
                                //ItemDetailScreenDestination.route + "?id=${it.id}"
                                //"item_detail_scr"+"?myId=${it.id}"
                                //"item_detail_scr?myId=${it.id}"
                                //val routeWithArgs = "$route$routeArg{myId}"
                            )
                        },
                    )
                }
            }
        }
    }
}


@Composable
fun MyItem(
    modifier: Modifier = Modifier,
    item: Item,
    onItemClick: (Item) -> Unit,
) {
    Surface(
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(1.dp)
                .clickable {
                    onItemClick(item)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 4.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier,
                        text = item.title,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}