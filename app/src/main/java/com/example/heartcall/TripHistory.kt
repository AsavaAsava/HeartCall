package com.example.heartcall

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val trips = listOf(
    Trip("Keri Road", "Sunshine Apartments", 4.9f, "7:34 AM", imageResource = R.drawable.mombasa),
    Trip("Tikka Apartments", "Nairobi West Hospital", 4.9f, "6:30 AM", R.drawable.mombasa),

    // Add more trips here...
)
@Composable
fun TripHistoryApp(trips: List<Trip>) {
    MaterialTheme {
        Surface {
            Column {
                Text(
                    "Trip History",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                )
                LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)) {
                    items(trips) { trip ->
                        TripItem(trip)
                    }
                }
            }
        }
    }
}

@Composable
fun TripItem(trip: Trip) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = trip.imageResource),
                contentDescription = "Trip Image",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(trip.startLocation, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Place, contentDescription = "Location")
                    Text(trip.endLocation)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = "Rating", tint = Color.Yellow)
                    Text("${trip.rating}", fontWeight = FontWeight.Bold)
                    Text(" - ${trip.time}", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TripHistoryApp(trips)
}

// Data class to represent a trip
data class Trip(
    val startLocation: String,
    val endLocation: String,
    val rating: Float?,
    val time: String,
    val imageResource: Int // Drawable resource ID
)
