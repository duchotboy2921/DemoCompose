package com.demo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.demo.data.firebaseAPI.ProductCallBack
import com.demo.data.firebaseAPI.getNewProduct
import com.demo.data.isFinishLoaded
import com.demo.data.model.Product

class HomeViewmodel:ViewModel() {
    private val _listProduct = mutableStateListOf<Product>()
    val isOK = mutableStateOf(false)

    val listProduct:List<Product>
        get() = _listProduct

    fun getProductInHome(){
        try {
            getNewProduct(object :ProductCallBack{
                override fun getCallback(list: ArrayList<Product>) {
                    _listProduct.clear()
                    _listProduct.addAll(list)
                    isFinishLoaded.value = true
                } })
        }catch (ex:Exception){
            isFinishLoaded.value = false
        }
    }
}