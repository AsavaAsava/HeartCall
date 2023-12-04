package com.example.heartcall

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.heartcall.ui.theme.HeartCallTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.sp
import com.example.heartcall.ui.theme.appFontFamily
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState


class BookingDetail : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeartCallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LastBottomSheetM3()
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ModalBottomSheetM3() {

        var openBottomSheet by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        val bottomSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        Button(onClick = { openBottomSheet = true }) {
            Text(text = "Show Bottom Sheet")
        }

        if (openBottomSheet) {
            ModalBottomSheet(
                sheetState = bottomSheetState,
                onDismissRequest = { openBottomSheet = false },
                dragHandle = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BottomSheetDefaults.DragHandle()
                        Text(text = "Comments", style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider()
                    }
                }
            ) {
                BottomSheetContent(
                    onHideButtonClick = {
                        scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                            if (!bottomSheetState.isVisible) openBottomSheet = false
                        }
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LastBottomSheetM3() {

        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()


        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = 350.dp,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Request Details", fontSize = 30.sp)
                }
                Row(modifier = Modifier.fillMaxWidth().padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
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
                val context = LocalContext.current
                LazyColumn(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    item() {
                        ListItem(
                            headlineContent = { Text(text = "Pickup Location") },
                            leadingContent = {
                                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                            }
                        )
                    }
                    item() {
                        ListItem(
                            headlineContent = { Text(text = "Strathmore University") },

                        )
                    }
                    item() {
                        ListItem(
                            headlineContent = { Text(text = "Dropoff Location") },
                            leadingContent = {
                                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                            }
                        )
                    }
                    item() {
                        ListItem(
                            headlineContent = { Text(text = "Nairobi West Hospital") },

                            )
                    }

                    item {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {context.startActivity(Intent(context, RatingActivity::class.java))}
                        ) {
                            Text(text = "Continue")
                        }
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) { val nairobi = LatLng(-1.3093,36.8125)
                val end = LatLng(-1.297, 36.874)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(nairobi, 15f)
                }
                val sourceMarkerState = rememberMarkerState(
                    key = "start",
                    position = nairobi
                )
                val destinationMarkerState = rememberMarkerState(
                    key = "finish",
                    position = end
                )
                val points = listOf(
                    LatLng(-1.3093, 36.8125),
                    LatLng(-1.3085, 36.8150),
                    LatLng(-1.3077, 36.8175),
                    LatLng(-1.3070, 36.8200),
                    LatLng(-1.3062, 36.8225),
                    LatLng(-1.3055, 36.8250),
                    LatLng(-1.3047, 36.8275),
                    LatLng(-1.3039, 36.8300),
                    LatLng(-1.3031, 36.8325),
                    LatLng(-1.3023, 36.8350),
                    LatLng(-1.3015, 36.8375),
                    LatLng(-1.3008, 36.8400),
                    LatLng(-1.3000, 36.8425),
                    LatLng(-1.2992, 36.8450),
                    LatLng(-1.2984, 36.8475),
                    LatLng(-1.2976, 36.8500),
                    LatLng(-1.2969, 36.8525),
                    LatLng(-1.2961, 36.8550),
                    LatLng(-1.2953, 36.8575),
                    LatLng(-1.2945, 36.8600),
                    LatLng(-1.2937, 36.8625),
                    LatLng(-1.2930, 36.8650),
                    LatLng(-1.2922, 36.8675),
                    LatLng(-1.2914, 36.8700),
                    LatLng(-1.2906, 36.8725),
                    LatLng(-1.2898, 36.8750),
                    LatLng(-1.2890, 36.8775),
                    LatLng(-1.2883, 36.8800),
                    LatLng(-1.2875, 36.8825),
                    LatLng(-1.2867, 36.8850),
                    LatLng(-1.297, 36.874)
                )

                GoogleMap(
                    cameraPositionState = cameraPositionState,
                ) {
                    Polyline(points = points)

                    Marker(state = sourceMarkerState)
                    Marker(state = destinationMarkerState)

                }
            }
        }
    }

    @Composable
    fun BottomSheetContent(
        onHideButtonClick: () -> Unit
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(5) {
                ListItem(
                    headlineContent = { Text(text = "Item $it") },
                    leadingContent = {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                    }
                )
            }
            item {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(text = "Continue")
                }
            }
        }
    }
}