package com.example.socialuijp.ui.theme.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialuijp.model.Post
import com.example.socialuijp.ui.theme.AppGray
import com.example.socialuijp.ui.theme.Gray_Dark
import com.example.socialuijp.ui.theme.Magenta_Lighter
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun PostView(postList: ArrayList<Post>) {
    LazyColumn {
        items(postList.size) { index ->
            PostItem(postList[index])
        }
    }
}

@Composable
fun PostItem(post: Post) {
    var isLiked by remember { mutableStateOf(post.like) }
    Column(Modifier.padding(8.dp)) {
        Row {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .height(40.dp)
                    .width(40.dp)
                    .align(CenterVertically),
                elevation = 8.dp,
                shape = RoundedCornerShape(50)
            ) {
                GlideImage(
                    imageModel = post.user.avatar,
                    loading = {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                        )
                    },
                    contentScale = ContentScale.Crop,
                    failure = {
                        Text(text = "image request failed.")
                    })
            }
            Column(
                Modifier
                    .weight(1f)
                    .align(CenterVertically)
            ) {
                Text(
                    text = post.user.username,
                    fontSize = 12.sp,
                    color = if (isSystemInDarkTheme()) AppGray else Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(6.dp, 1.dp)
                )
                Text(
                    text = post.location,
                    fontSize = 10.sp,
                    color = AppGray,
                    fontWeight = FontWeight.Bold, modifier = Modifier.padding(6.dp, 1.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "",
                    modifier = Modifier.align(CenterVertically)
                )
            }

        }
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(5)
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxSize()
                    .height(300.dp),
                imageModel = post.image,
                loading = {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )
                },
                contentScale = ContentScale.Crop,
                failure = {
                    Text(text = "image request failed.")
                })
        }
        Row {
            IconButton(onClick = {
                isLiked = !isLiked
                post.like = isLiked
            }) {
                Icon(
                    if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = if (isLiked) Magenta_Lighter else AppGray
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Send, contentDescription = "", tint = AppGray)
            }
        }
        Text(
            text = post.caption,
            fontSize = 11.sp,
            color = if (isSystemInDarkTheme()) AppGray else Gray_Dark,
            modifier = Modifier.padding(8.dp, 1.dp)
        )
    }
}