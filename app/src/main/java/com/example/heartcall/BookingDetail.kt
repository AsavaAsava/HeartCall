package com.example.heartcall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
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
            sheetPeekHeight = 300.dp,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Request Details", fontSize = 30.sp)
                }

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
                            headlineContent = { Text(text = "Mbagathi Hospital") },

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
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) { val nairobi = LatLng(1.2921,36.8219)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(nairobi, 15f)
                }

                val points = listOf(
                    LatLng(1.2921, 36.8219),
                    LatLng(1.2931, 36.8220),
                    LatLng(1.2960, 36.8221)
                )

                GoogleMap(
                    cameraPositionState = cameraPositionState,
                ) {
                    Polyline(points = points)
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