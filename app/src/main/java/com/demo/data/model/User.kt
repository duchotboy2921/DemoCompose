package com.demo.data.model

data class User(var username:String = "",var password:String="",var productsInCart:MutableList<Product> = mutableListOf(),var purchasedProducts:MutableList<Product> = mutableListOf() ) {
}