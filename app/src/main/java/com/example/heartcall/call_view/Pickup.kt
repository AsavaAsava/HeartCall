package com.example.heartcall.call_view

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartcall.EmergencyScreen
import com.example.heartcall.RatingActivity
import com.example.heartcall.ui.theme.appFontFamily


var trips : List<Trip> = listOf<Trip>(
    Trip("Keri Road","Nairobi Hospital",1.5,30,"Medical"),
    Trip("Lenana Road","Kenyatta Hospital",2.0,20,"Accident")
    
)

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
            LazyColumn{
                items(items=trips){
                    PreviousLocationCard(trip = it)
                }
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
fun PreviousLocationCard(trip :Trip){
    val context = LocalContext.current
    val modifier :Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 0.dp, vertical = 8.dp).clickable {
            context.startActivity(Intent(context,RatingActivity::class.java))
        }
    Box (modifier=modifier){
        Column {
            Divider()
            Spacer(modifier = Modifier.size(8.dp))
        Row(modifier=Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
            Icon(imageVector = Icons.Default.Done, contentDescription = "Clock Icon", tint = Color.Gray)
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(text = trip.from, fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)

                Text(text="Nairobi", fontFamily = appFontFamily, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
    }

}