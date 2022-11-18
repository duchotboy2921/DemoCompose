package com.demo.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.data.currentScreen
import com.demo.data.firebaseAPI.ProductCallBack
import com.demo.data.firebaseAPI.getNewProduct
import com.demo.data.firebaseAPI.getNewProduct1
import com.demo.data.isFinishLoaded
import com.demo.data.loadingState
import com.demo.data.model.Product
import com.demo.data.stateToNavigate
import com.demo.nav.LoadingState
import com.demo.nav.ScreenNavigation
import com.demo.nav.StateToNavigate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewmodel:ViewModel() {
    private val _listProduct = mutableStateListOf<Product>()
    val isOK = mutableStateOf(false)

    val listProduct:List<Product>
        get() = _listProduct

    fun getProductInHome(){
        loadingState.value = LoadingState.Loading
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
    // test async await but not work
    fun getProductInHome1(){
        viewModelScope.launch(Dispatchers.IO){
            var list = getNewProduct1()
            withContext(Dispatchers.Main){
                _listProduct.clear()
                _listProduct.addAll(list)
                Log.d("get_product",list.size.toString())
                isFinishLoaded.value = true
            }
        }
    }
    fun navigateToMenuScreen(){
        currentScreen.value = ScreenNavigation.MenuScreen
        stateToNavigate.value = StateToNavigate.HomeToOther
    }
    fun disableLoading(){
        loadingState.value = LoadingState.DoneLoading
    }
}