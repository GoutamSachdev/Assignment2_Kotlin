package com.example.lab2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*

import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import com.example.lab2.ui.theme.Lab2Theme

class Task3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    loopTask3()
                }
            }
        }
    }
}

@Composable
fun loopTask3(){
    val imageUrls = arrayOf(
        "https://thesimplycoder.com/wp-content/uploads/2020/02/iron-man.jpg",
        "https://thesimplycoder.com/wp-content/uploads/2020/02/hulk.jpg",
        "https://thesimplycoder.com/wp-content/uploads/2020/02/spider-man.jpg",
        "https://thesimplycoder.com/wp-content/uploads/2020/02/wolverine.jpg",
        "https://thesimplycoder.com/wp-content/uploads/2020/02/black-widow.jpg",
        "https://thesimplycoder.com/wp-content/uploads/2020/02/thor.jpg"
    )

    val marvelCharacters =
        arrayOf("Iron Man", "Hulk", "SpiderMan", "Wolverine", "Black Widow", "Thor")
    val characterAges = arrayOf("35", "42", "22", "137", "34", "150")


    LazyColumn {
        items(marvelCharacters.size) { index ->
            val painter1 =  rememberImagePainter(imageUrls[index])
            val characterName = marvelCharacters[index]
            val characterAge = characterAges[index]
            task3(nameValue = characterName, Age = characterAge.toString(), painter = painter1)
        }
    }
}
    @Composable
    fun task3(

        modifier: Modifier = Modifier,
        nameValue: String = "",
        Age: String = "",
        painter: Painter

    ) {
        Row(
            modifier = modifier
                .shadow(4.dp, shape = RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .padding(bottom = 20.dp)


        ) {
            // Column with Image (RoundedCorner)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 30.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.primary)
                )
            }

            // Column with two TextFields (Name and Phone Number)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(end = 10.dp)
            ) {
                // Name TextField
                Text(
                    text = "$nameValue",
                    fontWeight = FontWeight.W900,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 2.dp)
                )

                // Phone Number TextField
                Text(
                    text = "Age $Age",
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Lab2Theme {
        task3(painter = painterResource(id = R.drawable.whatsapp))
    }
}