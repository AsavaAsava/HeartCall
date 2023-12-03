package com.example.heartcall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartcall.call_view.Appbar
import com.example.heartcall.call_view.CallMap
import com.example.heartcall.call_view.PickupContainer
import com.example.heartcall.ui.theme.HeartCallTheme

class CallActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeartCallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CallView()
                }
            }
        }
    }
}

@Preview(name="Call View")
@Composable
fun CallView(){
    val modifier : Modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f)
        .background(Color.White)

    Box (modifier = modifier){
        CallMap()
        Appbar()
        Box(modifier= Modifier
            .fillMaxHeight(0.4f)
            .align(Alignment.BottomCenter)
            .clip(
                RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
            )
            .background(Color.White)
            .padding(16.dp)) {
            PickupContainer()

        }
    }
}
@Composable
fun Pickup(){
    val modifier = Modifier

}