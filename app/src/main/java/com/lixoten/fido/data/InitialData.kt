package com.lixoten.fido.data

import com.lixoten.fido.model.Item

object InitialData {

    fun getItems() =
        List(4) {
            Item(
                id = it,
                title = "Item # $it",
                content = ""
            )
        }
}