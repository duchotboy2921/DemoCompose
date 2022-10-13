package com.demo.data.firebaseAPI

import com.demo.data.model.Product

interface ProductCallBack {
    fun getCallback(list: ArrayList<Product>)
}