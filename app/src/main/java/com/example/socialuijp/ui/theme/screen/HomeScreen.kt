package com.example.socialuijp.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialuijp.model.MockData
import com.example.socialuijp.ui.theme.AppGray
import com.example.socialuijp.ui.theme.component.PostView
import com.example.socialuijp.ui.theme.component.StoryView


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navController: NavController){
    Column {
    Spacer(modifier = Modifier.height(8.dp))
    StoryView(MockData.storyList, navController)
    Spacer(modifier = Modifier.height(8.dp))
    Divider(modifier = Modifier.padding(10.dp, 0.dp), color = AppGray, thickness = 0.5.dp)
    Spacer(modifier = Modifier.height(8.dp))
    PostView(MockData.postList)
}
}