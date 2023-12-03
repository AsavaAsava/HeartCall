package com.example.heartcall.call_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartcall.R

@Composable
fun HamburgerIcon(){
    val modifier : Modifier = Modifier
        .size(35.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primary)
    Box (modifier=modifier, contentAlignment = Alignment.Center){
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon", tint = Color.White)

    }
}

@Composable
fun AppLogo(){
    var modifier : Modifier = Modifier

    Text(text = stringResource(id = R.string.app_name), color = MaterialTheme.colorScheme.primary, fontSize = 20.sp, fontFamily = FontFamily(fonts = listOf(
        Font(resId = R.font.fredoka_one)
    ))
    )
}

@Composable
fun ProfilePhoto(){
    val modifier : Modifier = Modifier
        .size(35.dp)
        .clip(CircleShape)

    Image(
        painter = painterResource(id = R.drawable.itadori),
        contentDescription = "User Profile Photo",

        modifier = modifier,
        contentScale = ContentScale.FillBounds
    )

}
@Preview(name = "Appbar")
@Composable
fun Appbar(){
    val modifier : Modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)

        .clip(
            RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
        )
        .background(Color.White)
        .padding(8.dp)
    Row (modifier=modifier, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        HamburgerIcon()
        AppLogo()
        ProfilePhoto()
    }
}