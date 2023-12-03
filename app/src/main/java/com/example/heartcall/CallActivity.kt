package com.example.heartcall

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

import com.example.heartcall.call_view.Appbar
import com.example.heartcall.call_view.CallMap
import com.example.heartcall.call_view.PickupContainer
import com.example.heartcall.ui.theme.HeartCallTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class CallActivity : ComponentActivity() {
    private var locationPermissionGranted by mutableStateOf(false)
    private var lastKnownLatLng by mutableStateOf(LatLng(-1.2921,36.8219))

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            locationPermissionGranted = isGranted
            if (isGranted) {
                checkLocationPermission()
            }
        }

    private fun checkLocationPermission() {
        when (PackageManager.PERMISSION_GRANTED) {
            checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) -> {
                locationPermissionGranted = true
                val fusedLocationClient: FusedLocationProviderClient =
                    LocationServices.getFusedLocationProviderClient(this)
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location ->
                        if (location != null) {
                            lastKnownLatLng = LatLng(location.latitude, location.longitude)
                        }
                    }
                    .addOnFailureListener { _ ->
                        // Handle the failure if needed
                    }


            }
            else -> {
                requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkLocationPermission()
        setContent {
            HeartCallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CallView(onCurrentLocationClick = { checkLocationPermission() }, location = lastKnownLatLng)
                }
            }
        }
    }
}

@Composable
fun CallView(onCurrentLocationClick : ()->Unit,location : LatLng){

    val modifier : Modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f)
        .background(Color.White)

    Box (modifier = modifier){
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState =  rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(location, 15f)
            }
        ) {
            Marker(
                state = MarkerState(position = location),
                title = "Nairobi",
                snippet = "Marker in Nairobi"
            )
        }
        Appbar()
        Box(modifier= Modifier
            .fillMaxHeight(0.4f)
            .align(Alignment.BottomCenter)
            .clip(
                RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
            )
            .background(Color.White)
            .padding(16.dp)) {
            PickupContainer { onCurrentLocationClick() }

        }
    }
}
