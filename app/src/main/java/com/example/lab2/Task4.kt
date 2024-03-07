package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.lab2.ui.theme.Lab2Theme

class Task4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                        loopTask()


                }
            }
        }
    }
}
@Composable
fun task4(

    modifier: Modifier = Modifier,
    nameValue: String = "",
    Age: String = "",
    painter: Painter

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, bottom = 10.dp)

    ) {
        // Image with background
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .height(140.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.primary)
        )

        // Text below the image

        Box(
            modifier = Modifier
                .width(150.dp)
                .padding(bottom = 10.dp)

        ) {
            Text(
                text = "$nameValue",
                fontWeight = FontWeight.W900,

                color = Color.White, // Set text color
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 115.dp, end = 16.dp,)
                    .background(color = Color.Cyan)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loopTask() {
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


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top Bar
        TopAppBar(
            title = { Text(text = "Marvel Characters") },
            modifier = Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary),

        )
        LazyColumn {
            items(
                marvelCharacters.size / 2
            ) { rowIndex ->
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                    // Distribute available space evenly
                ) {
                    val index1 = rowIndex * 2
                    val index2 = index1 + 1

                    item {

                        task4(
                            nameValue = marvelCharacters[index1],
                            Age = characterAges[index1].toString(),
                            painter = painterResource(id = R.drawable.whatsapp)
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.width(0.dp)) // Add spacing between images
                        val painter2 = painterResource(id = R.drawable.whatsapp)
                        task4(
                            nameValue = marvelCharacters[index2],
                            Age = characterAges[index2].toString(),
                            painter = painter2
                        )
                    }
                }
            }
//
        }
    }
  }

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Lab2Theme {
        Greeting3("Android")
    }
}