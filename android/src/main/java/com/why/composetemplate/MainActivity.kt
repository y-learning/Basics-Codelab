package com.why.composetemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Cyan) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Preview(showBackground = true, name = "Preview Greeting")
@Composable
fun DefaultPreview() {
    Greeting(name = "Jetpack Compose")
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Greeting("Android 11")
        }
    }
}
