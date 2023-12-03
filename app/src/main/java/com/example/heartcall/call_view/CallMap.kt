package com.example.heartcall.call_view
//
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


val Nairobi : LatLng = LatLng(1.2921,36.8219)

@Preview
@Composable
fun CallMap() {

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(Nairobi, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state= MarkerState(position = Nairobi),
            title = "Nairobi",
            snippet = "Marker in Nairobi"
        )
    }
}

