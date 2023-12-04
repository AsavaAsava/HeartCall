package com.example.heartcall.call_view

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartcall.EmergencyScreen
import com.example.heartcall.MainActivity
import com.example.heartcall.ui.theme.appFontFamily

@Composable
fun PickupContainer(onCurrentLocationClick :()->Unit){
        Column {
            Text(text = "Where To Pickup?", fontFamily = appFontFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 32.dp,vertical=32.dp)) {
                CurrentLocationBtn(onCurrentLocationClick)
                CustomDivider()

                ChooseLocationBtn()
            }
            Spacer(modifier = Modifier.size(8.dp))
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                PreviousLocationCard(address = "Keri Road", city="Nairobi")
                PreviousLocationCard(address ="Lenana Road", city="Nyeri")

            }
        }


}

@Composable
fun CurrentLocationBtn(onClick: ()->Unit){
    val modifier : Modifier = Modifier
        .fillMaxWidth()
        .size(height = 50.dp, width = 0.dp)
    val context = LocalContext.current
    Button(
        onClick = {
                  context.startActivity(Intent(context, EmergencyScreen::class.java))
        },
        modifier = modifier

        ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "CurrentLocation",tint=Color.Black)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Use My Current Location", color = Color.White, fontFamily = appFontFamily, fontSize = 12.sp, fontWeight = FontWeight.W600)
            Spacer(modifier = Modifier.size(width = 50.dp, height = 0.dp))

        }
    }
}
@Composable
fun ChooseLocationBtn(){
    val modifier : Modifier = Modifier
        .fillMaxWidth()
        .size(height = 50.dp, width = 0.dp)

    OutlinedButton(
        modifier = modifier,
        onClick = {

        },


        ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,  modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "CurrentLocation",tint=Color.Black)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Choose a Different Location", color = MaterialTheme.colorScheme.primary, fontFamily = appFontFamily, fontSize = 12.sp, fontWeight = FontWeight.W600)
            Spacer(modifier = Modifier.size(width = 50.dp, height = 0.dp))

        }
    }
}
@Composable
fun CustomDivider(){
    val modifier : Modifier = Modifier
        .padding(3.dp)
        .size(3.dp, 5.dp)
        .background(Color.Gray)
    Column {
        Box(modifier = modifier)
        Box(modifier = modifier)
        Box(modifier = modifier)
        Box(modifier = modifier)


    }
}
@Composable
fun PreviousLocationCard(address:String,city:String){
    val modifier :Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 0.dp, vertical = 8.dp)
    Box (modifier=modifier){
        Column {
            Divider()
            Spacer(modifier = Modifier.size(8.dp))
        Row(modifier=Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
            Icon(imageVector = Icons.Default.Done, contentDescription = "Clock Icon", tint = Color.Gray)
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(text = address, fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)

                Text(text=city, fontFamily = appFontFamily, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
    }

}