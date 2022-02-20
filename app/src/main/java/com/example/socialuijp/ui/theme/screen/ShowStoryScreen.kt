package com.example.socialuijp.ui.theme.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.socialuijp.model.MockData
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ShowStoryScreen(index : Int){
    Card {
        Box(
            Modifier.fillMaxSize()
        ) {
            GlideImage(
                imageModel = MockData.storyList[index].img,
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
            }
        }
    }