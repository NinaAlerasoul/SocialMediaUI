package com.example.socialuijp.ui.theme.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialuijp.ui.theme.Magenta_Lighter
import com.example.socialuijp.ui.theme.VioletColor


@Composable
fun TopAppBar() {
    Row(Modifier.padding(8.dp, 0.dp)) {
        Text(
            modifier = Modifier.align(CenterVertically).weight(1f),
            text = "Instagram",
            fontFamily = FontFamily.Cursive,
            fontSize = 21.sp,
            color = if (isSystemInDarkTheme()) Color.White else VioletColor
        )
        IconButton(onClick = { /*TODO*/ }) {
            Box() {
                Icon(Icons.Filled.Send, contentDescription = "")
                Card(modifier = Modifier.align(BottomEnd).size(15.dp),
                    shape = RoundedCornerShape(50),
                    backgroundColor = Magenta_Lighter
                ) {
                    Text(text = "+7", color = Color.White, fontSize = 11.sp)
                }
            }
        }
    }
}