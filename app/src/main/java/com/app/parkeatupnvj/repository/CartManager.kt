package com.app.parkeatupnvj.repository

import com.app.parkeatupnvj.model.CartItem

object CartManager {

    val cartList = mutableListOf<CartItem>()

    fun tambahKeKeranjang(item: CartItem) {
        cartList.add(item)
    }

}