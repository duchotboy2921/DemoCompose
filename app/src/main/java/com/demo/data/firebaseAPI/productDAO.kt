package com.demo.data.firebaseAPI

import android.util.Log
import com.demo.data.dbProduct
import com.demo.data.model.Product

fun getNewProduct(productCallBack: ProductCallBack) {
     var list = ArrayList<Product>()
     dbProduct
         .limit(10)
         .get()
         .addOnSuccessListener {
             for(document in it){
                 var product = document.toObject(Product::class.java)
//                 stIMG.child(product.imgURL).downloadUrl.addOnSuccessListener {it1->
//                     product.imgURL = it1.toString()
//                     list.add(product)
//                     Log.d("product",product.imgURL)
//                 }
                 list.add(product)
             }
             productCallBack.getCallback(list)
         }.addOnFailureListener {
                Log.d("get_product","Cannot red product")
         }
}

