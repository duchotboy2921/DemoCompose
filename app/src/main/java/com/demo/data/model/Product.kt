package com.demo.data.model

data class Product(var productName:String ="",var price:Double=0.0,var  ratingStar:Double = 0.0
                   ,var quantity:Int = 0,var productCity:String = "", var imgURL:String = "",var idShop:String= "",var type:String = ""):java.io.Serializable {
}