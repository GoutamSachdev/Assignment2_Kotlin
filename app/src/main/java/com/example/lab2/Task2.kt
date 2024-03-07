package com.example.lab2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.Lab2Theme

class Task2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    task2(context = LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun task2(
    context: Context,
    modifier: Modifier = Modifier,
    nameValue: String = "",
    phoneNumberValue: String = "",
    onNameValueChange: (String) -> Unit = {},
    onPhoneNumberValueChange: (String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top=15.dp)

    ) {
        // Column with Image (RoundedCorner)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start=0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.whatsapp),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.primary)
            )
        }

        // Column with two TextFields (Name and Phone Number)
        Column(
            modifier = Modifier
                .weight(1.5f)
                .fillMaxHeight()
                .padding(end=8.dp)
        ) {
            // Name TextField
            TextField(
                value = nameValue,
                onValueChange = { onNameValueChange(it) },
                label = { Text("Name") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start=0.dp,bottom = 8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        // Focus on the next field (Phone Number)
                        onNameValueChange(nameValue)
                    }
                )
            )

            // Phone Number TextField
            TextField(
                value = phoneNumberValue,
                onValueChange = { onPhoneNumberValueChange(it) },
                label = { Text("Phone Number") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {


                    }
                )
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Lab2Theme {
        Greeting2("Android")
    }
}