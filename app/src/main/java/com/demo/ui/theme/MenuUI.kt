package com.demo.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.viewmodel.MenuViewModel

@Composable
fun MenuUI(menuViewModel: MenuViewModel){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            modifier = Modifier.padding(vertical = 30.dp),
            onClick = { menuViewModel.signOut()}) {
            Text(text = "Sign Out")
        }
    }
    BackHandler {
        menuViewModel.onBackPressed()
    }
}