package com.demo.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.R
import com.demo.data.isDarkTheme
import com.demo.data.isFinishLoaded
import com.demo.data.model.Product
import com.demo.viewmodel.HomeViewmodel

@Composable
fun HomeUI(homeModel: HomeViewmodel) {
    homeModel.getProductInHome()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(homeModel) }
    ) {
        Column(modifier = Modifier.wrapContentSize()) {
            Image(
                painter = painterResource(id = R.drawable.view1),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(200.dp)
            )
            displayAllProduct(homeModel = homeModel)
        }

    }
}

@Composable
fun displayAProduct(product: Product) {
    Card(
        modifier = Modifier
            .height(180.dp)
            .width(150.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.oki),
                contentDescription = "product_img",
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = product.productName,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Giá" + product.price,
                fontSize = 18.sp,
                color = Color.Red
            )
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun displayAllProduct(homeModel: HomeViewmodel) {
    val check by isFinishLoaded.collectAsState()
    if (check) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(vertical = 10.dp),
                cells = GridCells.Fixed(2),
                content = {
                    items(homeModel.listProduct.size) { index ->
                        displayAProduct(product = homeModel.listProduct[index])
                    }
                })
        }

    }
}

@Composable
fun BottomBar(homeModel: HomeViewmodel) {
    var selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation() {
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home btn") },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = { selectedIndex.value = 0 })
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite btn"
                )
            },
            label = { Text(text = "Like") },
            selected = (selectedIndex.value == 1),
            onClick = { selectedIndex.value = 1
                        isDarkTheme.value = !isDarkTheme.value})
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu btn") },
            label = { Text(text = "Menu") },
            selected = (selectedIndex.value == 2),
            onClick = { selectedIndex.value = 2
                        homeModel.navigateToMenuScreen()})
    }
}