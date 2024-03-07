package com.example.lab2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColorChangingButton()
                }
            }
        }
    }

}

@Composable
public fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun ColorChangingButton() {
    var isButtonClicked by rememberSaveable { mutableStateOf(false) }

    val buttonColor = if (isButtonClicked) Color.Green else Color.Red
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                isButtonClicked = !isButtonClicked
            },
            modifier = Modifier
                .padding(top = 2.dp)
                ,colors = ButtonDefaults.textButtonColors( buttonColor)
        ) {
            Text("Click Me")
        }
        Button(
            onClick = {
                val intent = Intent(context, Task2::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .padding(top = 2.dp)

        ) {
            Text("Task 2")
        }
        Button(
            onClick = {
                val intent = Intent(context, Task3::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .padding(top = 2.dp)

        ) {
            Text("Task 3")
        }
        Button(
            onClick = {
                val intent = Intent(context, Task4::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .padding(top = 2.dp)

        ) {
            Text("Task 4")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        Greeting("Android")
    }
}