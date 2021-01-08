package com.why.composetemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.why.composetemplate.theme.MyMaterialTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.h4)
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count.inc()) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 3) Color.Green else Color.LightGray
        )
    ) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun RowItem(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Row(modifier = modifier.padding(16.dp)) {
        content()
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "Compose")) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            for (name in names) {
                RowItem {
                    Greeting(name)
                }
                Divider()
            }
        }
        RowItem(modifier = Modifier.align(alignment = CenterHorizontally)) {
            val countState = remember { mutableStateOf(0) }

            Counter(countState.value) { newCount ->
                countState.value = newCount
            }
        }
    }
}

val GoldColor = Color(255, 215, 0)

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyMaterialTheme {
        Surface(color = GoldColor) {
            content()
        }
    }
}

@Preview(showBackground = true, name = "Preview MyApp")
@Composable
fun DefaultPreview() {
    MyApp { MyScreenContent() }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp { MyScreenContent() }
        }
    }
}
