package com.example.heartcall.call_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartcall.ui.theme.appFontFamily

@Preview(name="PickupView")
@Composable
fun PickupContainer(){
        Column {
            Text(text = "Where To Pickup?", fontFamily = appFontFamily, fontWeight = FontWeight.W600, fontSize = 16.sp)

            Column {
                CurrentLocationBtn()
                ChooseLocationBtn()
            }
        }


}

@Composable
fun CurrentLocationBtn(){
    val modifier : Modifier = Modifier.fillMaxWidth()
    Button(
        onClick = { },
        modifier = modifier

        ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "CurrentLocation",tint=Color.Black)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Use My Current Location", color = Color.White, fontFamily = appFontFamily, fontSize = 12.sp, fontWeight = FontWeight.W500)
        }
    }
}
@Composable
fun ChooseLocationBtn(){
    val modifier : Modifier = Modifier.fillMaxWidth()

    OutlinedButton(
        modifier = modifier,    +
        onClick = { },


        ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "CurrentLocation",tint=Color.Black)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Choose a Different Location", color = MaterialTheme.colorScheme.primary, fontFamily = appFontFamily, fontSize = 12.sp, fontWeight = FontWeight.W500)
        }
    }
}
