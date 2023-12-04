package com.example.heartcall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartcall.ui.theme.HeartCallTheme
import com.example.heartcall.ui.theme.appFontFamily

class RatingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeartCallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RatingView()
                }
            }
        }
    }
}
@Preview
@Composable
fun RatingView() {

    val modifier : Modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    Box(modifier=modifier) {
        RatingTitle()
        Box(modifier = Modifier
            .fillMaxHeight(0.9f).clip(RoundedCornerShape(20.dp,20.dp,0.dp,0.dp)).shadow(elevation = 5.dp)
            .background(Color.White)
            .align(Alignment.BottomCenter)) {
            TripContainer()
        }

    }
}



@Composable
fun RatingExitTitle() {
    val modifier: Modifier = Modifier
        .size(35.dp)
        .clip(CircleShape)
        .shadow(elevation = 5.dp)
        .background(Color.White)
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close Icon",
            tint = Color.Black
        )
    }
}
@Composable
fun RatingTitle(){
    Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier.padding(vertical = 32.dp, horizontal = 32.dp)) {
    RatingExitTitle()
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "Rate Your Trip",
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }
}

@Composable
fun TripDetails(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        val modifier : Modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)

        Image(
            painter = painterResource(id = R.drawable.itadori),
            contentDescription = "Trip Profile Photo",

            modifier = modifier,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier =Modifier.size(16.dp))
        Column {
            Text(text = "Nairobi West Hospital", fontFamily = appFontFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.size(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Like Icon", tint = Color(0xFFFFCC00))
                Text(text = "4.9", fontFamily = appFontFamily, fontWeight = FontWeight.W500, color = Color.Gray)
            }
        }
    }
}

@Composable
fun TripFeedback(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 16.dp)) {
        Row {
            Icon(imageVector = Icons.Default.Star, contentDescription = "Like Icon", tint = Color(0xFFFFCC00), modifier = Modifier.size(42.dp))
            Icon(imageVector = Icons.Default.Star, contentDescription = "Like Icon", tint = Color(0xFFFFCC00), modifier = Modifier.size(42.dp))
            Icon(imageVector = Icons.Default.Star, contentDescription = "Like Icon", tint = Color(0xFFFFCC00), modifier = Modifier.size(42.dp))
            Icon(imageVector = Icons.Default.Star, contentDescription = "Like Icon", tint = Color(0xFFFFCC00), modifier = Modifier.size(42.dp))
            Icon(imageVector = Icons.Default.Star, contentDescription = "Like Icon", tint = Color(0xFFFFCC00), modifier = Modifier.size(42.dp))

        }

        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier
            .fillMaxWidth()
            .size(height = 100.dp, width = 0.dp), placeholder = {Text(text = "Write Your Feedback" )} )

    }
}

@Composable
fun TripLocation(){
    Column(modifier = Modifier.padding(vertical = 24.dp)) {
        Text(text = "Trip Details", fontFamily = appFontFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.size(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription ="From Location", modifier = Modifier.size(32.dp) )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Keri Road", fontFamily = appFontFamily, fontWeight = FontWeight.W600, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription ="From Location", modifier = Modifier.size(32.dp), tint = MaterialTheme.colorScheme.primary )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Nairobi Hospital", fontFamily = appFontFamily, fontWeight = FontWeight.W600, fontSize = 16.sp)
        }
    }
}

@Composable
fun TripDistance(){
    Column(modifier=Modifier.padding(vertical = 16.dp)){
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)){
            Text(text = "Distance", fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)
            Text(text = "1.2km", fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)

        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)){
            Text(text = "Time", fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)
            Text(text = "30mins", fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)

        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)){
            Text(text = "Emergency", fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)
            Text(text = "Medical", fontFamily = appFontFamily, fontSize = 14.sp, fontWeight = FontWeight.W500)

        }

    }
}

@Composable
fun SubmitButton(){

    Button(onClick = {}, modifier = Modifier
        .padding(vertical = 32.dp)
        .fillMaxWidth()
        .size(height = 50.dp, width = 0.dp)) {
        Text(text = "Click To Submit")
    }
}
@Composable
fun TripContainer(){
    Column(Modifier.padding(32.dp)) {
        TripDetails()
        TripFeedback()
        TripLocation()
        TripDistance()
        SubmitButton()
    }
}