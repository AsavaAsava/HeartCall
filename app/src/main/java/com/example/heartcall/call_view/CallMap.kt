package com.example.heartcall.call_view
//
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


val Nairobi : LatLng = LatLng(1.2921,36.8219)
@Composable
fun CallMap(location: MutableState<LatLng>,) {
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState =  rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location.value, 15f)
    }
    ) {
        Marker(
            state = MarkerState(position = location.value),
            title = "Nairobi",
            snippet = "Marker in Nairobi"
        )
    }
}

