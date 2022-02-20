package com.example.socialuijp.ui.theme.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.socialuijp.model.Story
import com.example.socialuijp.ui.theme.Magenta_Lighter
import com.example.socialuijp.ui.theme.Shadow_Black
import com.example.socialuijp.ui.theme.VioletColor
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun StoryView(storiesItem: ArrayList<Story>, navController: NavController) {
    LazyRow {
        items(storiesItem.size + 1) { index ->
            if (index == 0)
                StoryItem(
                    story = Story(
                        "",
                        "https://www.gardendesign.com/pictures/images/675x529Max/site_3/helianthus-yellow-flower-pixabay_11863.jpg",
                        false,

                        ), navController, 0, true
                )
            else
                StoryItem(storiesItem[index - 1], index = index - 1, navController = navController)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StoryItem(story: Story, navController: NavController, index: Int, isMySelf: Boolean = false) {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(30),
        elevation = 8.dp,
        border = if (!isMySelf) BorderStroke(
            2.dp,
            if (story.isLived) Magenta_Lighter else VioletColor
        ) else null,
        onClick = {
            if (!isMySelf)
                navController.navigate("ShowStoryScreen/$index")
        }
    ) {
        Box(
            Modifier
                .width(70.dp)
                .height(90.dp)
        ) {
            GlideImage(
                imageModel = story.img,
                loading = {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                },
                contentScale = ContentScale.Crop,
                failure = {
                    Text(text = "image request failed.")
                })
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Shadow_Black)
            ) {
                Text(
                    text = story.username,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center, modifier = Modifier.align(
                        Alignment.Center
                    )
                )
                if (story.isLived)
                    Text(
                        text = "Live",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(
                                Alignment.BottomCenter
                            )
                            .background(Magenta_Lighter)
                            .padding(1.dp)
                    )
                if (isMySelf)
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.Center)
                    )
            }
        }

    }
}